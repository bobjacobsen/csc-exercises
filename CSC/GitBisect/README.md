## GitBisect - Using Git Bisect and Fixing Problems

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Gain familiarity with error-finding using bisect, and methods for fixing the bad commit.

First, set up the local environment:
```
   cd GitBisect
   source setup.sh
```

Then unpack a local git repository:

```
    tar xf GitBisect.tgz
```

It's very difficult to store a git repository inside a git repository, so we hide the .git directory and .gitignore file for this exercise within this tar file.

target.cpp is a small package for handling fixed size buffers of ints.
For reasons that don't concern us here, each int is held in a separately allocated location:
It's an array of int* pointer to ints, not an array of ints.

There have been a number of changes to this.  Use `gitk --all` to look at the series of commits.

It's worked all along with small buffers. To run it and see some output:

```
g++ target.cpp && ./a.out && ./a.out 5
```

(Yes, it would have been better to have real tests!  But this is typically written one-off code for our demo purposes.  You'll see similar things in real code...)

Large buffers originally worked:

```
git checkout Initial
g++ target.cpp && ./a.out 100
```

("Initial" is a tag we put at the first working version of the code)

Unfortunately, a bug was introduced into target.cpp at some point.
That test now segfaults with the most recent contents:

```
git checkout main
g++ target.cpp && ./a.out 100
```

You could debug this. You've learned about tools that will help find a memory access problem. But since we know that this was an introduced problem, we can use git bisect to find exactly the issue:

```
git bisect start
git bisect bad
```

That starts the process and tells git that the current content is a bad one.

```
git checkout Initial
git bisect good
```

This tells git that the "Initial" tag points to good contents.  Git will consider the commmits and merges between those two and create a plan for finding the issue, then check out some candidate commit for you to check

```
HEAD is now at a8b7040 initial contents
Bisecting: 5 revisions left to test after this (roughly 3 steps)
[c6f51d3ce09737323e2c6631e03dad1d9c676ac2] safety improvement
```

(Your output may vary, as this example was made before these instructions were committed)

Test this new commit with both short and long buffers:

```
g++ target.cpp && ./a.out && ./a.out 5 && ./a.out 100
```

If all that works OK, then do "git bisect good". If it fails, "git bisect bad".

Git will check out another commit and ask you to check that.
After just a few (i.e. about log_2(N_commits) ) attempts, it'll identify the tag where the
problem was introduced:

```
% git bisect bad
```
(hidden SHA so you do the exercise) is the first bad commit

followed by the log entry that shows who made the commit, the log message, and which files were changed.

You can look at exactly those changes with the log command.

```
git log -n 1 SHA
```

where "SHA" is the commit SHA you're currently working on.

The "-n 1" shows just that commit, which limits the output to just the useful part.
See what happens when you do "git log" without it.

If you want to see the detailed changes, add the -p option

```
git log -p -n 1 SHA
```

or do a specific diff between that commit and its predecessor:

```
git diff SHA~ SHA
```

Now you know what broke it.
You can end the bisect and can return to the front of the branch with

```
git bisect reset
```

Now, you have to fix it.  You can do that by coding a fix.  Or, as in this case,
if the commit is just a bad one, you can revert it.  Look up the "git revert" command.

```
git help revert
```

Then put together a revert command and try it. Look at the file contents to see how
they're changed, and test the result:

```
g++ target.cpp && ./a.out && ./a.out 5 && ./a.out 100
```

Use gitk to look at that file at some different versions to see where the change was applied.

Was the error completely removed from the history? Or is it present from the time it was entered to when you reverted it?

What if you want to completely remove that commit?  Git rebase can do this.
 - You need to be very careful doing this, as you're directly operating on your local repository in a way that's hard to reverse:  If you make a mistake, you may end up in the XKCD position of needing to reload!
- In particular, don't do this once you've pushed your content to another repository. It's possible do this safely, but it can be very confusing if people have based their work on the commit you're about to remove.

First, check out a clean copy of this repository into a new subdirectory with
```
mkdir rebase-test
cd rebase-test
tar xf ../GitBisect.tgz
```
We do that because you've modified the original one with the git revert you did above, and we want the problem to still be present for this part of the exercise.  Check that:

```
g++ target.cpp && ./a.out 100
```

Now let's *remove* the bad commit!

The form of the rebase command that we'll use is:

```
git rebase --onto "last good" "first good" "branch name"
```

The "-onto" says to rebase "first good" directly onto "last good", loosing commits in between. Use gitk or git log to look at the history and find the last SHA before the problem and the one immediately after. Your command should look something like

```
git rebase --onto f8ffe2a 5f9c17a main
```

Unfortunately, one file has been modified multiple times since then, so you'll get a message about a conflict:

```
%       git rebase --onto f8ffe2a 5f9c17a main
Auto-merging target.cpp
Auto-merging solution/note.txt
CONFLICT (content): Merge conflict in solution/note.txt
error: could not apply 0aa0ecf... test of different lengths
Resolve all conflicts manually, mark them as resolved with
"git add/rm <conflicted_files>", then run "git rebase --continue".
You can instead skip this commit: run "git rebase --skip".
To abort and get back to the state before "git rebase", run "git rebase --abort".
Could not apply 0aa0ecf... test of different lengths
```

Edit the conflicts out of the solution/note.txt file, then tell git to that you've done that and it's OK to continue with:

```
git add solution/note.txt
git rebase --continue
```

Rebase should complete now.  Refresh gitk or check the log to see what was done. The bad commit should be gone.  Try to run it:

```
g++ target.cpp && ./a.out 100
```

The problem is fixed not only in the head of the main branch, but also back in the past!

There are pluses and minuses to this technique.
 - If you're doing it locally to your own branches (not on master, as we did in this exercise), and you haven't pushed or pulled that to another repository, it's quite safe.
 - But if you've pushed this content elsewhere, you can get in trouble.  People might be counting on that commit for their own work. Pushing the _changed_ structure might end up requiring some special handling.

 Bottom line:  Revert is always safe, and usually recommended.  But if you're still working on some feature and haven't yet pushed or pulled it, rebasing an error away can give you a cleaner history when you do eventually push/pull and merge.

That ends our introduction to bisect for finding the commit that caused an error, and two techniques for correcting that error.

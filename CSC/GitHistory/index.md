## GitHistory - Branch Manipluations for Linear History

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Learn about ways of manipulating a branch to make its contents more understandable.

First, set up the local environment:
```
   cd GitHeadBanging
   source setup.sh
```

Then unpack a local git repository:

```
    tar xf GitHistory.tgz
```

It's very difficult to store a git repository inside a git repository, so we hide the .git directory and .gitignore file for this exercise within this tar file.

Take a look at the structure with `gitk --all`. You should see a `main` branch and several "FeatureN" working branches.

We'll work with Feature1 first.

```
git checkout Feature1
```

Take a look at the feature1.txt file on that branch.  We'll check later on that we've got the same contents.

There are a couple of ways to refer to a commit.  The most specific is the SHA.  The commit one commit behind head of the Feature1 branch is 9BB616 (note you can shorten a SHA, and 6 characters is almost always sufficient; Git will tell you if it needs more).  Try that:

```
git checkout 9BB616
```

Refresh gitk and it should show you that you are now checked out one commit behind the head. Check the feature1.txt file to see that it's consistent with that.

Let's do this again, but this time we'll use a shorthand notation for the commits, instead of the SHA.  This can save you a bit of work, because you don't have to look up and type in the SHA values.  There's a `~` notation to refer to parents of the current commit.  You need additional syntax to reach back past the last merge commit (which parent should it follow?) but in many cases it's a nice simplification.

HEAD refers to where you are now, and `HEAD~` means go back one.  You can also use `HEAD~1` for that, `HEAD~2` to go back two, etc.


```
git checkout HEAD~
```
Git will tell you that's switched to a new commit, and give you that commit's comment. Check the feature1.txt file to see that it's consistent with that.

Be sure you understand that HEAD is _not_ the top end of the branch.  It's just which commit you currently have checked out:  The head of the commits that lead to your current position.

Now that we know how that works, let's go back to the top of the branch and start again:
```
git checkout Feature1
```

Note: The following will invoke your default editor.  On lxplus, that's nano.  If you want to use something else, set the EDITOR environment variable before proceeding.
```
export EDITOR=\bin\...
```

We want to squash together the three commits in this branch:  Where we are now, and the two before.  The command for this is:

```
git rebase -i HEAD~3
```

Think of it as "squash together everything _after_ three commits previous to this one".

When you do that, an editor window will open that says

```
pick b76adc8 add first line
pick 9bb6169 add second line
pick 003e57a add 3rd, fix 2nd

# Rebase a8b7040..003e57a onto a8b7040 (3 commands)
#
# Commands:
# p, pick <commit> = use commit
# r, reword <commit> = use commit, but edit the commit message
# e, edit <commit> = use commit, but stop for amending
# s, squash <commit> = use commit, but meld into previous commit
# f, fixup [-C | -c] <commit> = like "squash" but keep only the previous
#                    commit's log message, unless -C is used, in which case
#                    keep only this commit's message; -c is same as -C but
#                    opens the editor
```

Plus some more options.

We want to use the first commit, squash the 2nd commit into the first, and squash the third commit into those.  So we edit the first three lines to say:

```
pick b76adc8 add first line
squash 9bb6169 add second line
squash 003e57a add 3rd, fix 2nd
```

save and exit the editor. Now that git knows what you want done, it will open another editor window:
```
# This is a combination of 3 commits.
# This is the 1st commit message:

add first line

# This is the commit message #2:

add second line

# This is the commit message #3:

add 3rd, fix 2nd

# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
#
```

It's asking you to make a new commit message describing the new squashed commit. To be helpful, it's showing you the commit messages from the three commits you've squashed together.  If you just save and exit the editor, git will concatenate those three to make the new commit message.  But we want something better, so add a summary:

```
Complete Function1 package, made of the following commits:

# This is a combination of 3 commits.
# This is the 1st commit message:

add first line

# This is the commit message #2:

add second line

# This is the commit message #3:

add 3rd, fix 2nd

# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
#
```

Some people like to leave the previous commits there for the record. Sometimes they clean them up a little so they look more presentable.  But you don't have to:  Some people delete them to give just the main message via the new comment.  When you have it the way you want it, save and exit the editor.

Now refresh gitk to see what the Feature1 branch looks like. You should see a single commit growing out of the Initial tag, with your new comment on it explaining all!

The Feature1 branch is still like any other one. You can add to it, merge it, branch off it, etc.  It's just been simplified.


### Setting Up For Fast Forward Merges

First, some comments on when to do this.  It's fine to use (or not use) fast forward merges while working on your own branches. You won't hurt anything, and a linear history is easier to understand, to search for problems, and to squash if you want to.

With distributed development, even if you've made your changes able to fast forward merge, somebody else might put something on main in the central repository that moves you off the HEAD of main again.  This is OK. If your collaboration is using linear history, they'll do their own rebase and fast-forward merge (or maybe squash, rebase and merge) when they accept your contribution, e.g. when they accept and merge your pull request.  If your collaboration is having you do merges to main, they'll tell you what you need to known to do it.

Now, on with the show.

There's also a Feature2 branch that we'll use for this part. Check it out, and take a look at its contents.

Notice that Feature2 branched from the Initial tag a while back, not from the HEAD of the main branch.  This is what we want to change.  The basic approach is "take the commits on the Feature2 branch and make equivalent ones starting at the end of the main branch"

The syntax for this is

```
git rebase main Feature2
```

this starts with main and adds the relevant parts of Feature2.  Git will say something like:

```
$ git rebase main Feature2
Successfully rebased and updated refs/heads/Feature2.
$
```

This is telling you that your branch Feature2 has been updated.

Important note:  In an earlier exercise we used the `--onto` option to _drop_ the commits in between two other commits.  We definitely don't want to do that here!  We're moving commits, not dropping them, so don't use `--onto`.

Refresh gitk and check the new structure. You should see that main is exactly the same as it ever was, but now there are three commits after `main` that correspond to the commits on Feature2.

Note that in the process, you have merged main into _your_ Feature2 branch.  All the main commits are present in Feature2.  But you have _not_ merged your branch into main.  The main branch pointer is still pointing to the same commit it always was.

If you now merge Feature2 into main, what do you expect to happen? (Don't do it now, we'll need Feature2 later)

You should expect to see that Feature2 is still pointing to the same commit it was, and now main is also pointing there. This is a fast-forward merge.

Note again:  In collaborative distributed development, you _shouldn't_ generally be commiting to main. We just did it here to show you what happens as part of the exercise. Let main be modified _in the central repository_ by PRs and merges, then pulled back to your local repo.   But merging main into your local branch is a good way to make it ready for that central merge process.  'git rebase' is a very clean way to do that.

Now that we have all the parts in place, please use `git rebase` to make the Feature1 branch ready to fast forward merge into main. First, a few questions:

 - Does it matter that Feature1's commits were earlier in time than Feature 2?
 - What command will you use to do this?
 - What structure do you expect to see in gitk after you're done? Sketch that out in detail to make sure.

Go ahead and do the rebase, then check gitk to see if you predicted the right structure.

Why is it like that?

What will happen when the Feature1 and Feature2 branches are submitted as PRs and merged?

Go ahead and merge Feature1 into main (special for this exercise), then look at the structure.  If Feature2 ready to fast-forward merge?  If not, what can you do about it?

And that's it for our quick tour of simple squashing and rebasing to make a more understandable commit history. There's more to it, of course. For example, you might have to handle conflicts. That ends up being very similar to handling conflicts in regular merges.

Hopefully we've given you enough of an overview so that you can think about using this both in your own work now, and when you're the one who's managing an entire repository.



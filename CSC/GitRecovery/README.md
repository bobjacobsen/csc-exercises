## GitRecovery - Resolving Issues at the Head of Your Branches

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Gain familiarity with tools for resolving issues at the head of branches.

First, set up the local environment:
```
   cd GitRecovery
   source setup.sh
```

Then unpack a local git repository:

```
    tar xf GitRecovery.tgz
```

It's very difficult to store a git repository inside a git repository, so we hide the .git directory and .gitignore file for this exercise within this tar file.

Take a look at the structure with `gitk --all`. You should see a `main` branch and several "FeatureN" working branches.

We'll work with Feature1 first.

```
git checkout Feature1
```

Take a look at the feature1.txt file on that branch.  We'll check later on that we've got the same contents.

### Referring to a specific commit

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

### Last commit in branch was bad

Imagine that the last commit at the front of the Feature1 branch is just bad.  Maybe it didn't work, maybe you think it's a dead end.

#### Start a new branch with a different approach

If you're not sure about that, one approach is to create a new Feature1A branch without that last commit, and continue with that.  Think for a minute about how to do that, and write down the commands you plan to use.


<br>
<br>
<br>
<br>

One solution: Back up with HEAD~, the checkout -b to start the new branch:

```
git checkout HEAD~
git checkout -b Feature1A
```

Later on, you might decide that this Feature1A branch is fine, and want to rename that to Feature1.  Well, you can't really rename a Git branch, just like you can't move a hole.  But you can make a new branch by that name:

```
git branch -D Feature1
git checkout Feature1A   # just to make sure
git checkout -b Feature1
```


#### Remove the last commit

But let's say you're 100% certain that the last commit was bad, and you just want to make it go away.  The "git reset" command lets you back up on a branch by moving the branch pointer to an earlier commit.

There are some special cases based on whether or not you have changed, uncommitted files.

_Simplest case:_  No changed files.  No files added for later commit.

In this case, `git reset` just needs to know where you're going.  Let's try that.  Checkout the Feature2 branch and look at the feature2.txt file.

Then do:
```
git reset HEAD~
```

Look at the feature2.txt file, `git status` and use gitk to see the status of the Feature2 branch.  You should find that
 - The actual branch has been moved back one commit
 - But the feature2.txt file has not been changed - it's showing as modified and ready to commit

 This form of the `git reset` command really does undo the last commit, leaving the directory as it looked right before you did that commit:  With a modified file ready to and and commit.

 If you now want to get rid of those changes to the file, you can use the usual
 ```
 git checkout -- feature2.txt
 ```

 to make the file consistent with the checked-out contents.

 _Slightly more complicated case:_ You have added one or more changed files, but don't want to commit those. This involves another form of `git reset` without arguments:

 ```
 git reset

 ```

 This will un-add all added files.  You can un-add just one file with:

 ```
 git reset feature2.txt
 ```

 for example.  Go ahead and make a change to feature2.txt, `git add` it and then undo that.

 <br>
 <br>
 <br>
 <br>

 The way to remember this is that `git reset` is really like `git reset HEAD`: Put all the files back the way they are with the current HEAD commit.  Note that the change you made is still in the file:  You can add and recommit it if you want to.

Finally, if you can't remember this form of the command, do a `git status`.  You should see something like:


```
% git status
On branch Feature2
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
	modified:   feature2.txt
```

That form of the `git restore` command will also do this.  I have trouble remembering it, so prefer the simple `git reset`, but either is fine.


Summary:  We've seen a couple ways of dealing with things that go wrong at the HEAD of a branch.  Hopefully, when something goes wrong, you won't need to "delete and reload a new copy" now.  That can lose a lot of your work if you're not careful (and lucky)....






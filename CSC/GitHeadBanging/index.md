## GitHeadBanging - Branch Manipluations

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Learn about ways of manipulating the head of a branch

First, set up the local environment:
```
   cd GitHeadBanging
   source setup.sh
```

Then unpack a local git repository:

```
    tar xf GitHeadBanging.tgz
```

It's very difficult to store a git repository inside a git repository, so we hide the .git directory and .gitignore file for this exercise within this tar file.

Take a look at the structure with gitk.  You should see a `main` branch and several "FeatureN" working branches.

We'll work with Feature1 first.

```
git checkout Feature1
```

Take a look at the feature1.txt file on that branch.  We'll check later on that we've got the same contents.

There are a couple of ways to refer to a commit.  The most specific is the SHA.  The commit one commit behind head of the Feature1 branch is 9BB616 (note you can shorten a SHA, and 6 characters is almost always sufficient; Git will tell you if it needs more).  Try that:

```
git checkout 9BB616
```

gitk should show you that you are now checked out one commit behind the head. Check the feature1.txt file to see that it's consistent with that.

Let's do this again, but this time we'll use a shorthand notation for the commits, instead of the SHA.  This can save you a bit of work, because you don't have to look up and type in the SHA values.  There's a `~` notation to refer to parents of the current commit.  It's complex to reach back past the last merge commit (which parent should it follow?) but in many cases it's a nice simplification.

HEAD refers to where you are now, and `HEAD~` means go back one.  You can also use `HEAD~1` for that, `HEAD~2` to go back two, etc.


```
git checkout HEAD~
```
Git will tell you that's switched to a new commit, and give you that commit's comment. Check the feature1.txt file to see that it's consistent with that.














We want to merge this onto main with linear history.  To do that, we need to move the starting point of the branch from the middle of the history out to the HEAD of that main branch. `git rebase` will do that for you.

We want to change the history such that the start of the branch (SHA ...) is attached to the end of master.  One form of the command that will do this is:

```
```

Specifically, for this branch
```
```

(Note the shorted SHAs)
Go ahead and do that, then look at the contents of the repository.  Do you see how the branch now appears at the end and how history has been changed?  We've added this branch as linear history!

Note that the SHAs of the commits have changed.  The hashing algorithm includes the upstream hash, so when you rebase a commit you change it's SHA.  The old nodes with their original SHAs are still there, they're just not visible. They'll be garbage collected later.




Let's do the same thing with the Feature2 branch, but this time we'll use a shorthand notation for the commits, instead of the SHA.  This can save you a bit of work, because you don't have to look up and type in the SHA values.  There's a `~` notation to refer to parents of the last current commit.  It's complex to reach back past the last merge commit (which parent should it follow?) but in many cases it's a nice simplification.

In this case the command is
```
```










Let's do the same thing with the Feature3 branch, but this time we'll squash the commits down to just one.  In the process, we'll change the individual commit messages to one that captures all the changes.

```
git checkout Feature2
```


Note: This will invoke your default editor.  On lxplus, that's nano.  If you want to use something else, set the EDITOR environment variable before proceeding.
```
export EDITOR=\bin\...
```








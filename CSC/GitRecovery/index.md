## GitRecovery - Resolving Issues at the Head of Your Branches

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Gain familiarity with tools for resolving issues at the head of branches.

First, set up the local environment:
```
   cd GitBisect
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

#### Start a new branch with a different approach

#### Remove the last commit


### When merges go bad


#### Giving up


#### Simplifying complicated merges


#### Git checkout --; git stash  (Move this upward)


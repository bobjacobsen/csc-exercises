## GitBasics2: Branching and Merging

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Gain familiarity branches and merges

This exercise works in a slightly different way than the
<a href="../GitBasics1/README.md">previous one</a>,
which you should have completed first if you're not already familiar with
Git. To reduce the amount of typing involved, we've got a
<a href="ex_script.sh">shell script</a>
for you to run that does the typing. It periodically stops to allow you to check the results in a
separate window.

### Basic Operations

If you haven't done it already, you have to tell Git who you are:

```shell
git config --global user.email "you@example.com"
git config --global user.name "Your Name"
```
There's no default for this, but you only need to do it once.

Next, create a work area:

```shell
cd GitBasics2
source setup.sh
mkdir exerciseG2
cd exerciseG2/
```
Then run the script:

```shell
../ex_script.sh
```
It will create a new repository for you, then stop.

Open another window in which to check things, and in that (after navigating to the CSC directory and doing `setup`) do:

```shell
cd GitBasics2/exerciseG2
gitk --all &
gitg &
```

The `gitg` tool  might not be installed on your machine, as it's an optional component. If it is available, select "Branches" to get the best display.

Now hit "enter" or "return" to step through the script one section at a time.  At each pause,

 - Look at what commands the script has executed
 - Look at the contents.txt file
 - Refresh the gitk and gitg displays by hitting F5 or selecting "Refresh" from the menu
 - Look at the gitk and gitg displays to see how the repository structure changes
 - and maybe do some `git log` or other commands to see the details.

Some brief summary information is below.

The goal here is to understand how branches can be created, how
you move back and forth between them, and how the merging process works.

 - First the repository is created.  After this, git commands will work and gitk will have a repository to display.
 - Two commits on master show how it grows in the simplest possible case.
 - Branch A_dev is created and two commits are done on it. What is the master branch doing while this is happening?
 - Shows how to transition back to the master branch with a single command, then make a change there.
 - B creates a branch, but doesn't switch to it or use it
 - Still on the master, another commit.  What are the branches doing now?
 - And now B is working on the B_dev branch.  What is A_dev doing?
 - Two more commits on the master branch. Note that both B_dev and master have changes since they were last in contact. How can they be combined?
 - B wanted to merge those changes on the master branch onto her development (B_dev) branch so keep it up to date. They conflicted, and that had to be managed. Master unchanged.
 - B does a little more work.
 - B brings her branch back onto master for others to appreciate. Note this doesn't require a merge, and leaves B_dev containing nothing that's not in the master.
 - So finally that branch goes away.

We would definitely be interested in hearing whether this follow-along method works better or worse than the cut&amp;paste in other exercises! Please send an
<a href="mailto:jacobsen@berkeley.edu?subject=CSC-GitBasics2">email to jacobsen@berkeley.edu</a> with your comments and suggestions.


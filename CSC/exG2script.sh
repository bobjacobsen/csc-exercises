#!/bin/bash
set -v verbose #echo on

rm -rf .git
git init

read -p "Repository created ([Enter] to proceed) "

echo 'Initial commit' > contents.txt
git add contents.txt
git commit -m'Initial commit'

echo 'Commit 2 on master' >> contents.txt
git add contents.txt
git commit -m'Commit 2 on master'

read -p "Two commits on master ([Enter] to proceed) "

# Developer A decides to do some work off the master branch
git branch A_dev
git checkout A_dev

echo 'Commit A1 on A_dev' >> contents.txt
git add contents.txt
git commit -m'Commit A1 on A_dev'

echo 'Commit A2 on A_dev' >> contents.txt
git add contents.txt
git commit -m'Commit A2 on A_dev'

read -p "Two commits on the A_dev branch ([Enter] to proceed) "

# now we move back to watching work on the master branch
git checkout master

echo 'Commit 3 on master' >> contents.txt
git add contents.txt
git commit -m'Commit 3 on master'

echo 'Commit back on master' >> contents.txt

# Developer B decides to do some work off the master branch
# and creates a branch of her own to prepare
git branch B_dev

read -p "B_dev branch created, not yet used ([Enter] to proceed) "

# More is done on the master
echo 'Commit 4 on master' >> contents.txt
git add contents.txt
git commit -m'Commit 4 on master'

read -p "One more commit on master ([Enter] to proceed) "

# Developer B gets started
git checkout B_dev

echo 'Commit B1 on B_dev' >> contents.txt
git add contents.txt
git commit -m'Commit B1 on B_dev'

echo 'Commit B2 on B_dev' >> contents.txt
git add contents.txt
git commit -m'Commit B2 on B_dev'

echo 'Commit B3 on B_dev' >> contents.txt
git add contents.txt
git commit -m'Commit B3 on B_dev'

read -p "B is committing to B_dev branch ([Enter] to proceed) "

# meanwhile, back on the master, two changes are made
git checkout master

echo 'Commit 5 on master' >> contents.txt
git add contents.txt
git commit -m'Commit 5 on master'

echo 'Commit 6 on master' >> contents.txt
git add contents.txt
git commit -m'Commit 6 on master'

read -p "Two more commits on master branch ([Enter] to proceed) "

# Now B wants to merge those on his branch
git checkout B_dev

git merge master

# that results in a conflict:
cat contents.txt

# B decides to put her changes before the new master ones:
cat <<EOD >contents.txt
Initial commit
Commit 2 on master
Commit 3 on master
Commit B1 on B_dev
Commit B2 on B_dev
Commit B3 on B_dev
Commit 4 on master
Commit 5 on master
Commit 6 on master
EOD

git add contents.txt
git commit -m"fix merge with master"

read -p "Merging master changes into B ([Enter] to proceed) "

# note that master isn't changed yet, just the B_dev branch
git status

# B makes two more changes
echo 'Commit B3 on B_dev' >> contents.txt
git add contents.txt
git commit -m'Commit B3 on B_dev'

echo 'Commit B4 on B_dev' >> contents.txt
git add contents.txt
git commit -m'Commit B4 on B_dev'

read -p "B makes a few more changes on branch, then ready to merge back onto master ([Enter] to proceed) "

# now we're ready to bring B's code back to the main line of development
# so we switch back to working on master
# and merge

git checkout master
git merge B_dev

# That's called a "fast-forward merge", because no files are actually changed,
# master is just updated to point at the specific contents from B_dev

git status
read -p "Merging B back onto the master ([Enter] to proceed) "

# B is now done with that branch, and can delete it or leave it for later
git branch --merged
git branch -d B_dev
git branch








git checkout A_dev

echo "A_dev commit 1" >> contents.txt
git commit -am"A_dev commit 1"

git checkout -b A_dev_an_idea
echo "A_dev_an_idea commit" >> contents.txt
git commit -am"A_dev_an_idea commit"

# that didn't work out, back to A_dev
git checkout A_dev

echo "A_dev commit 2" >> contents.txt
git commit -am"A_dev commit 2"

git checkout -b A_dev_another_idea
echo "A_dev_another_idea commit 1" >> contents.txt
git commit -am"A_dev_another_idea commit 1"
echo "A_dev_another_idea commit 2" >> contents.txt
git commit -am"A_dev_another_idea commit 2"

# that didn't work out, back to A_dev
git checkout A_dev

echo "A_dev commit 3" >> contents.txt
git commit -am"A_dev commit 3"

git checkout -b A_dev_bright_idea
echo "A_dev bright idea" >> contents.txt
git commit -am"A_dev bright idea"

git checkout -b A_dev_dumb_idea
echo "A_dev dumb idea" >> contents.txt
git commit -am"A_dev dumb idea"

# back to A_dev
git checkout A_dev
echo "A_dev commit 4" >> contents.txt
git commit -am"A_dev commit 4"

# bright idea carries the day!
git checkout A_dev_bright_idea
echo "A_dev bright idea 2" >> contents.txt
git commit -am"A_dev bright idea 2"

echo "A_dev bright idea 3" >> contents.txt
git commit -am"A_dev bright idea 3"

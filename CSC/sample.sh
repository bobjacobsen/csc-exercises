sudo find /home -name exercise\* > sample.txt
echo exercise1 `grep "exercise1$" sample.txt | wc | awk '{print $1}'`
echo exercise2 `grep "exercise2$" sample.txt | wc | awk '{print $1}'`
echo exerciseD `grep "exerciseD$" sample.txt | wc | awk '{print $1}'`
echo
echo exercise3 `grep "exercise3$" sample.txt | wc | awk '{print $1}'`
echo exercise4 `grep "exercise4$" sample.txt | wc | awk '{print $1}'`
echo
echo exercise5 `grep "exercise5$" sample.txt | wc | awk '{print $1}'`
echo
echo exerciseC `grep "exerciseC$" sample.txt | wc | awk '{print $1}'`
echo exerciseG1 `grep "exerciseG1$" sample.txt | wc | awk '{print $1}'`
echo exerciseG2 `grep "exerciseG2$" sample.txt | wc | awk '{print $1}'`
echo exerciseG3 `grep "exerciseG3$" sample.txt | wc | awk '{print $1}'`
echo
echo exerciseM1 `grep "exerciseM1$" sample.txt | wc | awk '{print $1}'`
echo exerciseM2 `grep "exerciseM2$" sample.txt | wc | awk '{print $1}'`
echo exercise7 `grep "exercise7$" sample.txt | wc | awk '{print $1}'`
echo exercise8 `grep "exercise8$" sample.txt | wc | awk '{print $1}'`
echo exercise9 `grep "exercise9$" sample.txt | wc | awk '{print $1}'`


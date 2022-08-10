umask 0022
chmod 755 .
setenv CLASSPATH .:junit.jar:PerfAnal.jar
../csc_log file TestSumPrimesJava

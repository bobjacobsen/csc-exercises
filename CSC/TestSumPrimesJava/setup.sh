umask 0022
chmod 755 .
export CLASSPATH=".:junit.jar:PerfAnal.jar"
../csc_log file TestSumPrimesJava

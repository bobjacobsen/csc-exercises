mkdir -p /home/jake/results/`basename $PWD`
chmod -f 777 /home/jake/results/`basename $PWD`
mkdir -p /home/jake/results/`basename $PWD`/`whoami`
chmod 733 /home/jake/results/`basename $PWD`/`whoami`
cp *.java /home/jake/results/`basename $PWD`/`whoami`


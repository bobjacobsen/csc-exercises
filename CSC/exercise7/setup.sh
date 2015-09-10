export CMTHOME=/home/jake/cmt-dev/CMT/v1r18p20050501
export CMTBIN=Darwin-PowerMacintosh
#export CMTBIN=Linux-i686
#export CMTLIB=Darwin

export CMTROOT=${CMTHOME}
export CMTPATH=`pwd`
source ${CMTHOME}/mgr/setup.sh

export   LD_LIBRARY_PATH=${PWD}/A/V1/${CMTLIB}:${PWD}/B/v1/${CMTLIB}
export DYLD_LIBRARY_PATH=${PWD}/A/V1/${CMTLIB}:${PWD}/B/v1/${CMTLIB}


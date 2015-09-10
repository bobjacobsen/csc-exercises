setenv CMTHOME /home/jake/cmt-dev/CMT/v1r18p20050501
setenv CMTBIN Darwin-PowerMacintosh
#setenv CMTBIN Linux-i686
setenv CMTLIB Darwin

setenv CMTROOT ${CMTHOME}
setenv CMTPATH `pwd`
source ${CMTHOME}/mgr/setup.csh

setenv   LD_LIBRARY_PATH ${PWD}/A/V1/${CMTLIB}:${PWD}/B/v1/${CMTLIB}
setenv DYLD_LIBRARY_PATH ${PWD}/A/V1/${CMTLIB}:${PWD}/B/v1/${CMTLIB}


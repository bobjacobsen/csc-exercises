#!/bin/bash

echo MALLOC_CHECK_ is "'$MALLOC_CHECK_'"
echo 
echo '---- one ----'
$1 one.cpp
$2 ./a.out

echo '---- two ----'
$1 two.cpp
$2 ./a.out

echo '---- three ----'
$1 three.cpp
$2 ./a.out

echo '---- four ----'
$1 four.cpp
$2 ./a.out

echo '---- five ----'
$1 five.cpp
$2 ./a.out

echo '---- six ----'
$1 six.cpp
$2 ./a.out

echo '---- seven ----'
$1 seven.cpp
$2 ./a.out

echo '---- eight ----'
$1 eight.cpp
$2 ./a.out

echo '---- nine ----'
$1 nine.cpp
$2 ./a.out

echo '---- ten ----'
$1 ten.cpp
$2 ./a.out

echo '---- eleven ----'
$1 eleven.cpp
$2 ./a.out

echo '---- twelve ----'
$1 twelve.cpp
$2 ./a.out


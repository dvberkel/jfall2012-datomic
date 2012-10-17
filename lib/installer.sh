#! /usr/bin/env bash

usage()
{
cat<<EOF
usage: $0 options

this script downloads the Datomic library into the lib directory, 
creating the lib directory if it does not exist.

OPTIONS
  -h  Show this message
  -e  which edition of datomic to download, either 'pro' or 'free', defaults to 'free'
  -v  which version of datomic to download, defaults to '0.8.3551'
EOF
}

EDITION='free'
VERSION='0.8.3551'
while getopts "he:v:" OPTION; do
    case $OPTION in
	h)
	    usage
	    exit 1
	    ;;
	e)
	    EDITION=$OPTARG
	    ;;
	v)
	    VERSION=$OPTARG
	    ;;
	?)
	    usage
	    exit
	    ;;
    esac
done

PRODUCT="datomic-${EDITION}-${VERSION}.zip"
URL="http://downloads.datomic.com/${VERSION}/${PRODUCT}"

if [ ! -d "lib" ]; then
    mkdir lib
fi;

wget -P lib $URL
unzip -d lib "lib/${PRODUCT}"

#! /usr/bin/env bash

##          author: torstein@escenic.com
## last modifed by: $Author: torstein $
##         version: $Revision: #1 $ $Date: 2016/01/21 $
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob


print() {
  echo $(basename $0):${BASH_LINENO[0]}:${FUNCNAME[1]}"()" "$*"
}

checkout_source() {
  print "Checking out $1 ..."
}

compile_source() {
  print "Compiling source in $1 ..."
}

start_dev_server() {
  print "Starting dev server on port $1 ..."
}

main() {
  checkout_source https://github.com/eclipse/che.git
  compile_source che
  start_dev_server 8080
}

main "$@"

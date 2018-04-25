#! /usr/bin/env bash

##          author: torstein@escenic.com
## last modifed by: $Author: torstein $
##         version: $Revision: #1 $ $Date: 2016/01/21 $
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

bootstrap_thyself() {
  trap ups_show_help EXIT
  trap ups_another_help EXIT
}

ups_show_help() {
  echo "Something went wrong, have a cup of ☕"
}


ups_another_help() {
  echo "Yet another thing  went wrong, have a cup of ☕"
}

main() {
  bootstrap_thyself
  for i in 1 2 3 4 5; do
    echo "$(basename $0) running as $$ @ $(date) ..."
    sleep 5
  done
}

main "$@"

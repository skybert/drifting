#! /usr/bin/env bash

##          author: torstein@escenic.com
## last modifed by: $Author: torstein $
##         version: $Revision: #1 $ $Date: 2016/01/21 $
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

main() {
  for i in 1 2 3; do
    echo i=$i
    (
      if [ $i -eq 2 ]; then
        exit
      fi
    )
  done
}

main "$@"

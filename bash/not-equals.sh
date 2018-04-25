#! /usr/bin/env bash

##          author: torstein@escenic.com
## last modifed by: $Author: torstein $
##         version: $Revision: #1 $ $Date: 2016/01/21 $
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

main() {
  a=hei
  if [[ "${a}" != hei ]]; then
    echo a is not hei
  else
    echo a is hei
  fi
}

main "$@"

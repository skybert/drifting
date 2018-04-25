#! /usr/bin/env bash

##          author: torstein@escenic.com
## last modifed by: $Author: torstein $
##         version: $Revision: #1 $ $Date: 2016/01/21 $
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

main() {
  trap my_exit_hook EXIT
  /bin/false || {
    echo "I caught it!"
  }

}

my_exit_hook() {
  echo "exit hook in $0"
}
main "$@"

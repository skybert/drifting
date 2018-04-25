#! /usr/bin/env bash

##          author: torstein@escenic.com
## last modifed by: $Author: torstein $
##         version: $Revision: #1 $ $Date: 2016/01/21 $
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

main() {
  :

  declare -a my_a
  my_a=("one two")

  my_a=(
    ${my_a[@]-""}
    "added"
  )

  echo ${my_a[@]}
  echo "#" ${#my_a[@]}

}

main "$@"

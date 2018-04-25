#! /usr/bin/env bash

## author: torstein@escenic.com
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

populate_my_map() {
  my_map[one]=en
  my_map[two]=to
}


main() {
  declare -A my_map
  populate_my_map

  for el in "${!my_map[@]}"; do
    echo "$el"
  done
}

main "$@"

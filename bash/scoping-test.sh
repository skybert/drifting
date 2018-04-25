#! /usr/bin/env bash

set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

print() {
  echo $(basename $0):${BASH_LINENO[0]}:${FUNCNAME[1]}"()" "$*"
}

other_method() {
  print "I can read cache_dir=${cache_dir}"
}

main() {
  local cache_dir=/var/cache
  print "I have set cache_dir=${cache_dir}"
  print "Now calling other_method()"
  other_method
}


main "$@"
echo "$0 root here, now calling other_method"
other_method

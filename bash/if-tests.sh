#! /usr/bin/env bash

# by torstein@escenic.com
set -o errexit
set -o nounset
set -o pipefail

main() {
  local s="hi"
  if [ $s == "hi" ]; then
    echo "it's hi, alright (single [, double =)"
  fi
  if [ $s = "hi" ]; then
    echo "it's hi, alright (single [, single =)"
  fi
  if [[ $s == "hi" ]]; then
    echo "it's hi, alright (double [, double =)"
  fi

  s="hi world"
  if [ $s == "hi world" ]; then
    echo "it's hi world, alright (single [, double =)"
  fi
  if [ $s = "hi world" ]; then
    echo "it's hi world, alright (single [, single =)"
  fi
  if [[ $s == "hi world" ]]; then
    echo "it's hi world, alright (double [, double =)"
  fi

}

main "$@"

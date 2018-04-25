#! /usr/bin/env bash

# by torstein.k.johansen@gmail.com
set -o errexit
set -o nounset
set -o pipefail


main() {
  if [ -n "${variable-""}" ]; then
    echo "The variable is set"
  else
    echo "The variable is empty"
  fi

  if [ -n ${variable-""} ]; then
    echo "The variable is set"
  else
    echo "The variable is empty"
  fi

  if [ -n ${variable-} ]; then
    echo "The variable is set"
  else
    echo "The variable is empty"
  fi

  if [ -n "${variable-}" ]; then
    echo "The variable is set"
  else
    echo "The variable is empty"
  fi


}

main "$@"

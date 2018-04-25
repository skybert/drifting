#! /usr/bin/env bash

# by torstein.k.johansen@gmail.com
set -o errexit
# set -o nounset
set -o pipefail

read_user_input() {
  :
}

main() {
  declare -a publications
  publications=(
    'http://alpha.qa.local/'
    'http://beta.qa.local/'
    'http://gamma.qa.local/'
    'http://delta.qa.local/'
    'http://epsilon.qa.local/'
    'http://zeta.qa.local/'
    'http://eta.qa.local/'
    'http://ophelia.qa.local/'
    'http://caliban.qa.local/'
    'http://belinda.qa.local/'
    'http://bianca.qa.local/'
  )

  declare -a publications=()
  publications=(${publications[@]} "one")

  for (( i = 0; i < ${#publications[@]}; i++ )); do
    echo "${publications[$i]}"
  done

  echo "# array items:" ${#publications[@]}



}

main "$@"

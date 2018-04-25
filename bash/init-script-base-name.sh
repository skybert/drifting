#! /usr/bin/env bash

##          author: torstein@escenic.com
## last modifed by: $Author: torstein $
##         version: $Revision: #1 $ $Date: 2016/01/21 $
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

main() {
  l="
/etc/rc0.d/K01sse-proxy
/etc/rc1.d/K01sse-proxy
/etc/rc2.d/S02sse-proxy
/etc/rc3.d/S02sse-proxy
/etc/rc4.d/S02sse-proxy
/etc/rc5.d/S02sse-proxy
/etc/rc6.d/K01sse-proxy
"

  for el in $l; do
    echo "$(basename "$el" | sed 's#^[KS][0-9][0-9]##')"
  done
}

main "$@"

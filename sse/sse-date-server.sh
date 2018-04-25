#! /usr/bin/env bash

##          author: torstein@escenic.com
## last modifed by: $Author: torstein $
##         version: $Revision: #1 $ $Date: 2016/01/21 $
set -o errexit
set -o nounset
set -o pipefail
shopt -s nullglob

main() {

  while true ; do
    echo  "HTTP/1.1 200 OK
Server: BASH ${BASH_VERSION} ($(uname -s))
Content-Type: text/event-stream
Event: $(basename $0 .sh)
Data: $(date)

Received: [${@}]" |
      nc -l -p 1500;
  done

}

main "$@"

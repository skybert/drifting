#! /usr/bin/env bash

# by tkj@vizrt.com
grep '^\.XX' $* | sort -u | \
  sed 's#^\.XX \(.*\)$#\/^\\.XX \/s\/\1\/\1\/#'

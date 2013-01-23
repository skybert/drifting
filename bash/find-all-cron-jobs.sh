#! /usr/bin/env bash

# by tkj@vizrt.com

find /var/spool/cron/ /etc/cron* -name "cron*" |  \
  while read d; do find $d -type f; done | \
  egrep -v '.(placeholder|.SEQ)$' | \
  sort | \
  uniq

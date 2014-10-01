#! /usr/bin/env bash

db_prefix=jeeky

mysql <<EOF
create database ${db_prefix}db character set utf8 collate utf8_general_ci;
grant all on ${db_prefix}db.* to ${db_prefix}user@'%' identified by "${db_prefix}password";
grant all on ${db_prefix}db.* to ${db_prefix}user@'localhost' identified by "${db_prefix}password";
use ${db_prefix}db;
EOF


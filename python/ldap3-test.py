#! /usr/bin/python2
# -*- coding: utf-8-unix -*-

import ldap3

server = {
  "host": "172.18.0.5",
  "port": 1636
}

ldap_server = ldap3.Server(
  server["host"],
  port=server["port"],
  use_ssl=True
)
user = "cn=directory manager,o=gluu"
passwd = "foo"
oxauth_base = "o=gluu"

with ldap3.Connection(
    ldap_server,
    user,
    passwd
) as conn:
  conn.search(
    search_base=oxauth_base,
    search_filter="(oxScopeType=openid)",
    search_scope=ldap3.SUBTREE,
    attributes=['*']
  )

  if not conn.entries:
    print("no entries")
  else:
    print(conn.entries)

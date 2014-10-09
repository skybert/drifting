#! /usr/bin/env bash

# by torstein.k.johansen@conduct.no

jboss_home=/opt/jboss-eap-6.2/
mvn_opts="-o -q"
mvn ${mvn_opts} clean package -f $(dirname $0)/../pom.xml && \
  ${jboss_home}/bin/standalone.sh

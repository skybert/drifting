#! /usr/bin/env bash

# by torstein.k.johansen@conduct.no

jboss_cli_connect="/opt/jboss-eap-6.2/bin/jboss-cli.sh -c"
mysql_driver=~/.m2/repository/mysql/mysql-connector-java/5.1.30/mysql-connector-java-5.1.30.jar

function add_jdbc_module() {
  ${jboss_cli_connect} <<EOF
module add \
  --name=com.mysql \
  --resources=${mysql_driver} \
  --dependencies=javax.api
EOF
}

function add_driver {
  ${jboss_cli_connect} <<EOF
/subsystem=datasources/jdbc-driver=mysql:add( \
  driver-name=mysql, \
  driver-module-name=com.mysql, \
  driver-class-name=com.mysql.jdbc.Driver \
)
EOF
}

add_jdbc_module
add_driver

#! /usr/bin/env bash

# by torstein.k.johansen@conduct.no

jboss_cli_connect="/opt/jboss-eap-6.2/bin/jboss-cli.sh -c"
datasource_name=jeeky-ds

${jboss_cli_connect} <<EOF
data-source add \
     --name=jeeky-ds \
     --driver-name=mysql \
     --connection-url=jdbc:mysql://localhost:5432/jeekydb \
     --jndi-name=java:jboss/jdbc/jeekydb \
     --user-name=jeekyuser \
     --password=jeekypassword

data-source enable --name=jeeky-ds
EOF


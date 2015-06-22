#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy jaz4jsfdemo
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/jaz4jsfdemo.war

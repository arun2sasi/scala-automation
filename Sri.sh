#!/bin/sh

PROPERTY_FILE=apps.properties

function getProperty {
   PROP_KEY=$1
   PROP_VALUE=`cat $PROPERTY_FILE | grep "$PROP_KEY" | cut -d'=' -f2`
   echo $PROP_VALUE
}

echo "# Reading property from $PROPERTY_FILE"
REPOSITORY_URL=$(getProperty "nexus.repository.url")

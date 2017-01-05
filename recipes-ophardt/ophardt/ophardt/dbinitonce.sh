#!/bin/sh

SCRIPT_DIR=`dirname $0`
if ! mysql -u root -e 'use score_fencing' > /dev/null 2>&1; then
  $SCRIPT_DIR/dbupdate.sh
fi
true

#!/bin/sh

SCRIPT_DIR=`dirname $0`
mysql -u root < $SCRIPT_DIR/general.sql
mysql -u root score_fencing < $SCRIPT_DIR/structure.sql
mysql -u root score_fencing < $SCRIPT_DIR/data.sql

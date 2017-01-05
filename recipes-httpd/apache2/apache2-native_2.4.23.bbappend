# Apache 2.4.23 was removed from the download area on apache.org
# However it's still on archive.apache.org. There's a patch for
# morty in the queue, which will fix this. Then, this bbappend can
# be removed
#
# see https://patchwork.openembedded.org/patch/135494/

SRC_URI_remove = "http://www.apache.org/dist/httpd/httpd-${PV}.tar.bz2"
SRC_URI_append = " http://archive.apache.org/dist/httpd/httpd-${PV}.tar.bz2"

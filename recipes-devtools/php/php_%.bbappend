FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:${THISDIR}/../../../meta-openembedded/meta-oe/recipes-devtools/php/php:"

SRC_URI += "file://0001-icu-path.patch"

DEPENDS += "curl icu libpcre libxml2 openssl zlib"

PACKAGECONFIG += "apache2 mysql soap"

CFLAGS += "-lpthread -ldl -lcrypt"

EXTRA_OECONF += "--enable-intl \
                 --with-icu-dir=${STAGING_BINDIR_CROSS} \
                 --with-config-file-scan-dir=${sysconfdir}/php/apache2-php5/conf.d \
                 --with-curl=${STAGING_DIR_HOST}${prefix} \
                 --with-openssl=${STAGING_DIR_HOST}${prefix} \
                 --with-pcre-regex=${STAGING_DIR_HOST}${prefix} \
                 --enable-libxml \
                 --with-libxml-dir=${STAGING_DIR_HOST}${prefix}"
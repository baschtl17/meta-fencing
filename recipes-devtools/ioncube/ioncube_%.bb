SUMMARY = "Ioncube loader"
DESCRIPTION = "Loaders for ionCube Secured Files"
HOMEPAGE = "http://www.ioncube.com/loaders.php"
LICENSE = "Ioncube_License"
LICENSE_FLAGS = "commercial"

require ioncube-${TARGET_ARCH}.inc

# we do not a checksum check in this recipe! The reason is that the
# ioncube company doesn't include the version number in the donwload
# tarball and older version are not provided. Hence we have to download
# the currently availabe version
BB_STRICT_CHECKSUM = "0"

SRC_URI += "file://ioncube-${TARGET_ARCH}.ini"

S = "${WORKDIR}/${PN}"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4180d7aa4c2bd10846dc3d35593bfe17"

INSANE_SKIP_${PN} += "already-stripped ldflags"

PHPEXTENSIONDIR = "${prefix}/lib/php5/extensions/no-debug-zts-20121212/"

do_install_append() {
  install -d ${D}${PHPEXTENSIONDIR}
  find ${WORKDIR}/ioncube/*.so -exec install -m 0755 \{} ${D}${PHPEXTENSIONDIR}/ \;

  install -d ${D}${sysconfdir}/php/apache2-php5/conf.d
  install -m 0644 ${WORKDIR}/ioncube-${TARGET_ARCH}.ini ${D}${sysconfdir}/php/apache2-php5/conf.d/ioncube.ini
}

FILES_${PN} = "${PHPEXTENSIONDIR} \
               ${sysconfdir}/php/apache2-php5/conf.d"
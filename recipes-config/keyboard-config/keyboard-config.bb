SUMMARY = "Keyboard configuration files"
DESCRIPTION = "Keyboard configuration files"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://vconsole.conf"

do_install() {
  # german keymap
  install -d ${D}${sysconfdir}
  install -m 0644 ${WORKDIR}/vconsole.conf ${D}${sysconfdir}/
}

DESCRIPTION = "systemd-networkd configuration"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://default.network"

inherit allarch

do_install() {
  install -d ${D}${sysconfdir}/systemd/network
  install -m 0644 ${WORKDIR}/default.network ${D}${sysconfdir}/systemd/network/
}

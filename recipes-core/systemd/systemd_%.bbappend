PACKAGECONFIG_append = "networkd resolved"

RRECOMMENDS_${PN}_remove = "${@bb.utils.contains('PACKAGECONFIG', 'serial-getty-generator', '', 'systemd-serialgetty', d)}"
SUMMARY = "A fencing tournament management software"
DESCRIPTION = "A fencing tournament management software"
HOMEPAGE = "http://www.ophardt-team.org"
LICENSE = "CLOSED"

DEPENDS = "base-passwd"
RDEPENDS_${PN} = "apache2 php-modphp ioncube mariadb oracle-jse-jre"

inherit allarch systemd

SRC_URI = "file://fencing.zip \
           file://database.zip \
           file://ophardt_license.yml \
           file://dbupdate.sh \
           file://dbinitonce.sh \
           file://ophardt.service \
           file://apache2-config/ophardt.conf \
           file://mysql-config/innodb.cnf \
           file://mysql-config/networking.cnf \
           file://php5-config/ophardt.ini \
           file://ophardt-master-avahi.service"

SYSTEMD_SERVICE_${PN} = "ophardt.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
  # fencing web sites
  install -d ${D}${localstatedir}/www 
  cp -r ${WORKDIR}/fencing ${D}${localstatedir}/www/
  chown -R daemon.daemon ${D}${localstatedir}/www

  # database
  install -d ${D}${localstatedir}/lib/ophardt/database
  install -m 0644 ${WORKDIR}/data.sql      ${D}${localstatedir}/lib/ophardt/database/
  install -m 0644 ${WORKDIR}/general.sql   ${D}${localstatedir}/lib/ophardt/database/
  install -m 0644 ${WORKDIR}/structure.sql ${D}${localstatedir}/lib/ophardt/database/
  install -m 0755 ${WORKDIR}/dbupdate.sh   ${D}${localstatedir}/lib/ophardt/database/
  install -m 0755 ${WORKDIR}/dbinitonce.sh ${D}${localstatedir}/lib/ophardt/database/

  # license file
  install -m 0644 ${WORKDIR}/ophardt_license.yml ${D}${localstatedir}/www/fencing/app/config/

  # systemd unit
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/ophardt.service ${D}/${systemd_unitdir}/system/

  # apache2 config
  install -d ${D}${sysconfdir}/apache2/conf.d
  install -m 0644 ${WORKDIR}/apache2-config/ophardt.conf ${D}${sysconfdir}/apache2/conf.d/

  # mysql/mariadb config
  install -d ${D}${sysconfdir}/my.cnf.d
  install -m 0644 ${WORKDIR}/mysql-config/innodb.cnf ${D}${sysconfdir}/my.cnf.d/
  install -m 0644 ${WORKDIR}/mysql-config/networking.cnf ${D}${sysconfdir}/my.cnf.d/

  # php config file
  install -d ${D}${sysconfdir}/php/apache2-php5/conf.d
  install -m 0644 ${WORKDIR}/php5-config/ophardt.ini ${D}${sysconfdir}/php/apache2-php5/conf.d/

  # avahi service definition
  install -d ${D}${sysconfdir}/avahi/services
  install -m 0644 ${WORKDIR}/ophardt-master-avahi.service ${D}${sysconfdir}/avahi/services/ophardt-master.service
}

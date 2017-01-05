DESCRIPTION = "Packages to be installed on Ophardt Touch server images"

inherit packagegroup

PACKAGES = "packagegroup-ophardt-server"

RDEPENDS_packagegroup-ophardt-server = "packagegroup-common \
                                        dropbear \
                                        avahi-autoipd \
                                        avahi-daemon \
                                        avahi-utils \
                                        ophardt"

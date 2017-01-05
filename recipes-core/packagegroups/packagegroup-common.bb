DESCRIPTION = "Packages to be installed on all images"

inherit packagegroup

PACKAGES = "packagegroup-common"

RDEPENDS_packagegroup-common = "keyboard-config \
                                network-config"

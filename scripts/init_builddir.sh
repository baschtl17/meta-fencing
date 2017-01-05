#!/bin/sh

git clone -b morty  https://git.yoctoproject.org/git/poky
cd poky

git clone -b morty  https://github.com/openembedded/meta-openembedded.git
git clone -b master https://git.yoctoproject.org/git/meta-oracle-java
git clone -b morty  https://git.yoctoproject.org/git/meta-intel
git clone -b master https://git.yoctoproject.org/git/meta-raspberrypi
git clone -b morty  https://github.com/OSSystems/meta-browser.git
git clone -b morty  https://github.com/baschtl17/meta-fencing.git

echo "TEMPLATECONF=${TEMPLATECONF:-meta-fencing/conf}" > .templateconf

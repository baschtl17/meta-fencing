# Some binaries (like oracle java) expect system libraries to be located
# in /lib64. It's not possible to install a symlink /lib64 -> /lib into
# the at rootfs generation time, because then, bitbake complains about
# already stripped and prelinked binaries. If /lib64 is a symlink, it would
# try to strip every lib twice.
# The solution is to install the symlink as package postinst at first boot

pkg_postinst_${PN}() {
  if [ x"$D" = "x" ]; then
    ln -s /lib /lib64
  else
    exit 1
  fi
}
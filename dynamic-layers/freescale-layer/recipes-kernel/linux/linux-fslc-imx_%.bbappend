FILESEXTRAPATHS:prepend := "${VIRTUALIZATION_EXTRA_LAYERDIR}/recipes-kernel/linux/files:"

SRC_URI:append = " file://virtualization.cfg"
SRC_URI:append = " file://criu-general.cfg"
SRC_URI:append = " file://criu-networking.cfg"
SRC_URI:append = " file://criu-optional.cfg"
SRC_URI:append = " file://criu-extra.cfg"

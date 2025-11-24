SUMMARY = "Bmaptool container image"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=39bba7d2cf0ba1036f2a6e2be52fe3f0"

SRC_URI = "\
    file://LICENSE \
"

S = "${UNPACKDIR}"

IMAGE_FSTYPES = "container oci"
inherit image
inherit image-oci

OCI_IMAGE_ENTRYPOINT = "/usr/bin/bmaptool"
OCI_IMAGE_TAG = "3.9.0${@['', '-${TCLIBC}'][d.getVar('TCLIBC') == 'musl']}"

IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""
NO_RECOMMENDATIONS = "1"

IMAGE_INSTALL = " \
    base-files \
    base-passwd \
    netbase \
    bmaptool \
"

# Allow build with or without a specific kernel
IMAGE_CONTAINER_NO_DUMMY = "1"

# Workaround /var/volatile for now
ROOTFS_POSTPROCESS_COMMAND += "rootfs_fixup_var_volatile ; "
rootfs_fixup_var_volatile () {
    install -m 1777 -d ${IMAGE_ROOTFS}/${localstatedir}/volatile/tmp
    install -m 755 -d ${IMAGE_ROOTFS}/${localstatedir}/volatile/log
}

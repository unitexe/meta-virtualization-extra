SUMMARY = "Looper quadlet"
DESCRIPTION = "A quadlet for a looper container"
AUTHOR = "unitexe"
SECTION = "unit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://looper.container"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
    install -D -p -m 0644 ${UNPACKDIR}/looper.container ${D}${sysconfdir}/containers/systemd/looper.container
}

FILES:${PN} = "${sysconfdir}/containers/systemd/looper.container"

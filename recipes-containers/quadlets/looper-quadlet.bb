SUMMARY = "Looper quadlet"
DESCRIPTION = "A quadlet for a looper container"
AUTHOR = "unitexe"
SECTION = "unit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

SRC_URI = "\
    file://looper.container \
    file://LICENSE \
"

S = "${UNPACKDIR}"

do_install() {
    install -D -p -m 0644 ${UNPACKDIR}/looper.container ${D}${sysconfdir}/containers/systemd/looper.container
}

FILES:${PN} = "${sysconfdir}/containers/systemd/looper.container"

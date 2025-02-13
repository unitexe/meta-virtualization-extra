SUMMARY = "Looper quadlet"
DESCRIPTION = "A quadlet for a looper container"
AUTHOR = "unitexe"
SECTION = "unit"
LICENSE = "MIT"

SRC_URI = "file://looper.container"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
    install -Dm 0644 ${UNPACKDIR}/looper.container ${D}${sysconfdir}/containers/systemd/
}

FILES:${PN} = "${sysconfdir}/containers/systemd/looper.container"

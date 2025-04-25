SUMMARY = "Nebula quadlet"
DESCRIPTION = "A quadlet for a nebula container"
AUTHOR = "unitexe"
SECTION = "unit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=96e896c6cbfcfdf1eb47e44674053a35"

SRC_URI = "\
    file://nebula.container\
    file://LICENSE \
"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
    install -d -p ${D}${sysconfdir}/nebula/pki
    install -d -p ${D}${sysconfdir}/nebula/cfg

    install -D -p -m 0644 ${UNPACKDIR}/nebula.container ${D}${sysconfdir}/containers/systemd/nebula.container
}

FILES:${PN} = "\
    ${sysconfdir}/nebula \
    ${sysconfdir}/containers/systemd/nebula.container \
"

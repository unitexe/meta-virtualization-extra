SUMMARY = "Podman quadlets"
DESCRIPTION = "A collection of podman quadlets"
AUTHOR = "unitexe"
SECTION = "unit"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

RDEPENDS:${PN}:append = " looper-quadlet"
RDEPENDS:${PN}:append = " nebula-quadlet"

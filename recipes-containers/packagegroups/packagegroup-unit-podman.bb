SUMMARY = "Podman packages"
DESCRIPTION = "A collection of packages to use podman"
AUTHOR = "unitexe"
SECTION = "unit"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

# A number of kernel modules are needed for this to work
RDEPENDS:${PN}:append = " kernel-modules"

# Checkpoint/restore
RDEPENDS:${PN}:append = " criu"
RDEPENDS:${PN}:append = " tar"

# Rootless containers
RDEPENDS:${PN}:append = " dbus"
RDEPENDS:${PN}:append = " dbus-broker"
RDEPENDS:${PN}:append = " libpam"
RDEPENDS:${PN}:append = " slirp4netns"

# Networking
RDEPENDS:${PN}:append = " iproute2"
RDEPENDS:${PN}:append = " netavark"

# Podman apps
RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " podman-tui"
RDEPENDS:${PN}:append = " podman-compose"

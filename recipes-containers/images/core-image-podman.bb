SUMMARY = "Experiment with podman"
DESCRIPTION = "An image for experimenting with podman"
AUTHOR = "unitexe"
SECTION = "containers"

inherit core-image

# Podman package
IMAGE_INSTALL:append = " podman"
IMAGE_INSTALL:append = " podman-tui"
IMAGE_INSTALL:append = " podman-compose"

# Needed for checkpoint/restore.
IMAGE_INSTALL:append = " criu"
IMAGE_INSTALL:append = " tar"

# Without this podman will not be able to do port binding.
IMAGE_INSTALL:append = " kernel-modules"

# Need for rootless containers.
IMAGE_INSTALL:append = " slirp4netns"
IMAGE_INSTALL:append = " dbus"
IMAGE_INSTALL:append = " dbus-broker"
IMAGE_INSTALL:append = " libpam"

# Needed for networking.
IMAGE_INSTALL:append = " iproute2"
IMAGE_INSTALL:append = " netavark"

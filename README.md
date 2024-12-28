# meta-virtualization-extra
An extension of [meta-virtualization](https://git.yoctoproject.org/meta-virtualization) that provides:
* Distro targets for building containers
  * `pokyless` (glibc)
  * `rocky` (musl)
* Machine targets for building containers
  * `amd64-container`
  * `arm64-container`
  * `armv7-container`
* Package group for using podman

## Building Containers With Yocto/OE
The work here related to building containers with yocto/oe is based on [meta-container-demo](https://github.com/konsulko/meta-container-demo/tree/master).

With the distro & machine targets mentioned above, one can build distroless app containers. The `pokyless` distro based on `poky` but it targets a dummy linux kernel and removes a bunch of `DISTRO_FEATURES`. The `rocky` distro is identical to `pokyless` but uses `musl` instead of `glibc`. Building the hello world flask app container provided by `meta-virtualization` results in a container tar image of about 10-12MB.

There are a number of talks that have been done related to this topic over the years (old to new).
* [Building Container Images with OpenEmbedded and the Yocto Project - Scott Murray](https://www.youtube.com/watch?v=OSyLoHYxGLQ)
* [Integrating Docker containers in Yocto by Sandra Tobajas, Sébastien LE STUM](https://www.youtube.com/watch?v=rrYnYJ8LxWM)
* [Containers built for Embedded Systems and Servers](https://www.youtube.com/watch?v=TBUL3vvXV8c)
* [Embedded Containers as a Deployment Component via the Yocto Project - Bruce Ashfield, AMD](https://www.youtube.com/watch?v=8twRZzp3Pi8)
* [YPDD 2023 - meta-virtualization: moving past source-only, basic containers](https://www.youtube.com/watch?v=6uHuMMCsT7s)
* [YPS 2023.11 - 2023/11/28 - Rudolf Streif - User Space Hands-on Class - Embedded Containers](https://www.youtube.com/watch?v=YHI8aCb3WFc)

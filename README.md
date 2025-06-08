# meta-virtualization-extra

## Use podman to pull and add images to local registry
Pull an image.
```bash
podman pull alpine
```

Tag it for local registry.
```bash
podman tag alpine localhost:5000/alpine
```

Push it to local registry.
```bash
podman push localhost:5000/alpine
```

Remove upstream image.
```bash
podman image rm alpine
```

Run image from local registry.
```bash
podman run -it localhost:5000/alpine /bin/sh
```

## Use skopeo to add images to local registry from USB
Pull alpine arm64 image and save as .tar to USB drive.
```bash
skopeo copy --override-arch arm64 docker://alpine:latest docker-archive:/media/$(whoami)/USB\ DISK/alpine-arm64.tar
```

Check what was saved.
```bash
skopeo inspect docker-archive:/media/$(whoami)/USB\ DISK/alpine-arm64.tar 
```

Should be something like:
```json
{
    "Digest": "sha256:058c92d86112aa6f641b01ed238a07a3885b8c0815de3e423e5c5f789c398b45",
    "RepoTags": [],
    "Created": "2025-02-14T03:28:36Z",
    "DockerVersion": "",
    "Labels": null,
    "Architecture": "arm64",
    "Os": "linux",
    "Layers": [
        "sha256:a16e98724c05975ee8c40d8fe389c3481373d34ab20a1cf52ea2accc43f71f4c"
    ],
    "LayersData": [
        {
            "MIMEType": "application/vnd.docker.image.rootfs.diff.tar.gzip",
            "Digest": "sha256:a16e98724c05975ee8c40d8fe389c3481373d34ab20a1cf52ea2accc43f71f4c",
            "Size": 8461312,
            "Annotations": null
        }
    ],
    "Env": [
        "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
    ]
}
```

Load .tar from USB drive into targets local registry.
```bash
skopeo copy docker-archive:/mnt/usb/alpine-arm64.tar docker://localhost:5000/alpine:latest
```

Verify image is local registry.
```bash
curl -X GET https://localhost:5000/v2/_catalog
```

Should output something like:
```json
{"repositories":["alpine"]}
```

And:
```bash
curl -X GET https://localhost:5000/v2/alpine/tags/list
```

Should output something like:
```json
{"name":"alpine","tags":["latest"]}
```

Now run alpine container from local registry.
```bash
podman run -it localhost:5000/alpine /bin/sh
```

## Run nebula lighthouse in container
```bash
sudo podman run -d --name nebula --network host --cap-add NET_ADMIN --device=/dev/net/tun --volume /home/$(whoami)$/.nebula/lighthouse/keys:/etc/nebula --volume /home/$(whoami)/.nebula/lighthouse/config:/config docker.io/nebulaoss/nebula:latest
```

# meta-virtualization-extra

## Using the local registry
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

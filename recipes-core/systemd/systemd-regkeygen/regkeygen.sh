#!/bin/sh



set -e

# Generate TLS certificate and key for local registry
mkdir -p /etc/registry
openssl req -x509 -newkey rsa:4096 -keyout /etc/registry/domain.key -out /etc/registry/domain.crt -days 365 -nodes -subj '/C=US/ST=Minnesota/L=St. Paul/O=unitexe/OU=/CN=localhost/emailAddress=unitexe70@gmail.com' -addext 'subjectAltName=DNS:localhost,IP:127.0.0.1,IP:::1'

# Add CA to system trust store
mkdir -p /usr/local/share/ca-certificates
cp /etc/registry/domain.crt /usr/local/share/ca-certificates/registry.crt
update-ca-certificates

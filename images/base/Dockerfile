FROM registry.access.redhat.com/ubi7-dev-preview/ubi-minimal:7.6
COPY bin /usr/local/bin

# Defualt operator name and namespace
ONBUILD ENV \
    NAMESPACE=github.com/example-inc \
    NAME=app-operator

ONBUILD ENV \
    OPERATOR=/usr/local/bin/${NAME} \
    USER_UID=1001 \
    USER_NAME=${NAME}


# install operator binary
ONBUILD COPY --from=builder /go/bin/${NAME} ${OPERATOR}
ONBUILD RUN  /usr/local/bin/user_setup
ONBUILD ENTRYPOINT ["/usr/local/bin/entrypoint"]
ONBUILD USER ${USER_UID}

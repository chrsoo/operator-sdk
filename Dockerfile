FROM golang:1.10-alpine3.8

ENV DEP_VERSION=v0.5.1 \
    GOPATH=/go \
    CGO_ENABLED=0 \
    GOOS=linux \
    GOARCH=amd64

# depends on the ENV defined above and thus needs to be on its on line
ENV GOFLAGS="-gcflags all=-trimpath=${GOPATH} -asmflags all=-trimpath=${GOPATH}" \
    OPERATOR_HOME=$GOPATH/src/github.com/operator-framework/operator-sdk/

RUN apk add --no-cache curl git make \
    && curl -sSL https://github.com/golang/dep/releases/download/${DEP_VERSION}/dep-${GOOS}-${GOARCH} -o /go/bin/dep \
    && chmod +x /go/bin/dep

ADD . ${OPERATOR_HOME}

RUN cd ${OPERATOR_HOME} && dep ensure -v
# RUN cd ${OPERATOR_HOME} && go build ${GOFLAGS} -o /go/bin/operator-sdk github.com/operator-framework/operator-sdk/cmd/operator-sdk

ONBUILD ARG NAME=app-operator
ONBUILD ARG NAMESPACE=github.com/example-inc

ONBUILD COPY . /go/src/${NAMESPACE}/${NAME}/
ONBUILD RUN cd /go/src/${NAMESPACE}/${NAME} \
    && dep ensure -v \
    && go build $GOFLAGS -o /go/bin/${NAME} ${NAMESPACE}/${NAME}/cmd/manager

FROM openjdk:8-jdk-alpine

ARG JAR_FILE
ARG PORT
ARG JAVA_OPTS="-Xms256m -Xmx4g"

EXPOSE ${PORT}

COPY target/${JAR_FILE} $HOME/app.jar
COPY docker/health-check.sh $HOME/health-check.sh

ENV HEALTH_CHECK_URL http://localhost:${PORT}/api/v1/health
ENV JAVA_OPTS ${JAVA_OPTS}

LABEL Dockerfile="https://github.com/paulstroie/light-microservice-base/docker/Dockerfile"

WORKDIR $HOME

USER root

RUN apk update \
    && apk add wget \
    && mkdir logs \
    && addgroup -S java && adduser -S java -G java \
    && chown -R java:java $HOME \
    && chmod +x health-check.sh

USER java

HEALTHCHECK --interval=30s --timeout=20s --start-period=120s --retries=3 CMD ./health-check.sh

CMD ["java", "-jar", "app.jar"]
#CMD while true; do sleep 12 ; echo "foreground"; done



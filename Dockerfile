FROM openjdk:11-slim

LABEL maintainer="Viktor Lipin"

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
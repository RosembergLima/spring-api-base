#*******************************************************************************
# Copyright (c) 2021 Sensormatic Electronics, LLC.  All rights reserved.
# Reproduction is forbidden without written approval of Sensormatic Electronics, LLC.
#*******************************************************************************

FROM gcr.io/tvc-common/jdk/eclipse-temurin:17-alpine
VOLUME /tmp
RUN mkdir /opt/app
COPY target/spring-api-base*.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]
EXPOSE 8080


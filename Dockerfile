#*******************************************************************************
# Copyright (c) 2021 Sensormatic Electronics, LLC.  All rights reserved.
# Reproduction is forbidden without written approval of Sensormatic Electronics, LLC.
#*******************************************************************************

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN mkdir /opt/app
COPY target/spring-api-base*.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]
EXPOSE 8080


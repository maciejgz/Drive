FROM adoptopenjdk/openjdk11:alpine

MAINTAINER maciejgz@github

WORKDIR /opt/drive
COPY target/drive.jar /opt/drive

ENTRYPOINT ["java", "-jar", "/opt/drive/drive.jar"]

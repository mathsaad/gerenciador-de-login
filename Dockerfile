FROM openjdk:8-alpine

MAINTAINER Matheus Saad

RUN apk update && apk add bash

RUN mkdir -p /opt/app

ENV PROJECT_HOME /opt/app

COPY target/spring-mongo-docker.jar $PROJECT_HOME/spring-mongo-docker.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-jar", "-Dspring.profiles.active=prod" ,"./spring-mongo-docker.jar"]
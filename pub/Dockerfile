FROM maven:3.3-jdk-8
MAINTAINER Manoel Silva
COPY . /pub
WORKDIR /pub
RUN mvn clean compile package 
WORKDIR /pub/target 
ENTRYPOINT java -jar pub-0.0.1-SNAPSHOT-spring-boot.jar
EXPOSE 8083
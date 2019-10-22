FROM maven:3.3-jdk-8
MAINTAINER Manoel Silva
COPY . /sub
WORKDIR /sub
RUN mvn clean compile package 
WORKDIR /sub/target
ENTRYPOINT java -jar sub-0.0.1-SNAPSHOT-spring-boot.jar
EXPOSE 8084
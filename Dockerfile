FROM maven:3.6.3-jdk-8
MAINTAINER Avanti Deshmukh

COPY . /usr/src/app/
WORKDIR /usr/src/app/
RUN mvn clean install
RUN mv target/Weather-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT java -jar app.jar


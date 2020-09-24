FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ADD TAR_FILE_POC-0.0.1-SNAPSHOT.jar TAR_FILE_POC-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/TAR_FILE_POC-0.0.1-SNAPSHOT.jar"]
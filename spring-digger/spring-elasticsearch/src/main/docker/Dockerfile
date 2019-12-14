FROM java:alpine
VOLUME /tmp
#ARG JAR_FILE=target/spring-elasticsearch-1.0.0.jar
COPY spring-elasticsearch-1.0.0.jar app.jar
#COPY JAR_FILE app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
MAINTAINER "klaus mikaelson"

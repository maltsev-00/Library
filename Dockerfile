FROM openjdk:12
EXPOSE 8080
ADD target/maltsev-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
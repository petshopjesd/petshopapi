FROM openjdk:24-jdk

COPY target/pet-0.0.1-SNAPSHOT.jar /petapi-v1.war

EXPOSE 8080

ENTRYPOINT ["java","-jar","/petapi-v1.war"]
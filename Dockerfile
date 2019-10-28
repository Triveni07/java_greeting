FROM openjdk:latest
EXPOSE 5000
ADD /target/greeting.jar greeting.jar
ENTRYPOINT ["java","-jar","greeting.jar"]


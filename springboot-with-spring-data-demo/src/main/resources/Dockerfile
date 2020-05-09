# Alpine Linux with OpenJDK JRE
FROM openjdk:8

ADD springboot-with-spring-data.jar springboot-with-spring-data.jar

## Springboot app running on port 8081
EXPOSE 8081

## Springboot Active profile is dev
CMD ["java", "-jar","-Dspring.profiles.active=dev", "springboot-with-spring-data.jar"]

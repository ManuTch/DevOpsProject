
FROM maven:3.8.3-openjdk-17 AS build


    
WORKDIR /usr/app

    
COPY pom.xml .


COPY src/ src/


RUN mvn clean package


FROM openjdk:17


WORKDIR /usr/app



COPY --from=build /usr/app/target/docker-taxe.jar docker-taxe.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar","docker-taxe.jar"]


FROM maven:3.8.3-openjdk-17 AS build


     # Définissez le répertoire de travail pour cette étape
WORKDIR /usr/app

     # Copiez le fichier pom.xml pour installer les dépendances
COPY pom.xml .


COPY src src/


RUN mvn clean package


FROM openjdk:21


WORKDIR /usr/app



COPY --from=build /usr/app/target/docker-taxe.jar docker-taxe.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar","docker-taxe.jar"]

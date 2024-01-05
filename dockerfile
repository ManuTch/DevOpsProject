# Première étape de construction
FROM maven:3.8.3-openjdk-17 AS build

# Définissez le répertoire de travail pour cette étape
WORKDIR /usr/app

# Copiez le fichier pom.xml pour installer les dépendances
COPY pom.xml .

# Copiez le répertoire src pour inclure les sources
COPY src src/

# Construisez l'application avec Maven
RUN mvn clean package

# Deuxième étape, utilisez une image OpenJDK plus légère pour l'exécution
FROM openjdk:17

# Définissez le répertoire de travail pour cette étape
WORKDIR /usr/app

# Copiez l'artefact JAR construit à partir de l'étape précédente
COPY --from=build /usr/app/target/*.jar app.jar

# Exposez le port 8080 pour que l'application puisse recevoir des connexions
EXPOSE 8080

# Commande à exécuter lors du démarrage du conteneur
ENTRYPOINT ["java", "-jar", "app.jar"]

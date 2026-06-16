# Etapa de build
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

# CORREÇÃO 1: O Render injeta a porta dinamicamente, não podemos travar na 8080
ENV PORT=8080
EXPOSE ${PORT}

# CORREÇÃO 2: Passar a variável de porta para o Java ler na inicialização
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
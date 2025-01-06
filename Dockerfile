FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests -e -X


# Fase final: Imagem minimalista para rodar a aplicação
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

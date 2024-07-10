# Use uma imagem base do Java
FROM openjdk:17-jdk-slim

# Configure o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR do aplicativo para o diretório de trabalho
COPY target/TrilhaBackEndJR-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta em que a aplicação vai rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

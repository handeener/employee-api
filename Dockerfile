# 1. Base image
FROM eclipse-temurin:21-jdk

# 2. Uygulama jar dosyasını ekle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# 3. Uygulama çalıştır
ENTRYPOINT ["java", "-jar", "/app.jar"]
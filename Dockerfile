# Java 21 için uyumlu OpenJDK imajını kullan
FROM openjdk:21-jdk-slim

# Çalışma dizinini ayarla
WORKDIR /app

# Maven ile oluşturulan JAR dosyasını kopyala
COPY target/*.jar app.jar

# Uygulamanın çalışacağı portu belirle
EXPOSE 8080

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]

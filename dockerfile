# Usa la imagen de Docker oficial de OpenJDK más reciente
FROM openjdk:latest

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu proyecto al contenedor
COPY target/puntodeventa/src/main/java/comunes/puntodeventa/MainApp.java /app/MainApp.java

# Comando que se ejecutará cuando el contenedor se inicie
CMD ["java", "-jar", "MainApp.java"]

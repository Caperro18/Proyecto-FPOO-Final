# Usa la imagen de Docker oficial de OpenJDK más reciente
FROM openjdk:latest

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu proyecto al contenedor (ajusta la ruta si es necesario)
COPY target/ /app/tu-proyecto.jar

# Expone el puerto en el que tu aplicación Java está escuchando
EXPOSE 8080

# Define el comando para ejecutar tu aplicación Java
CMD ["java", "-jar", "Punto de venta\src\main\java\comunes\puntodeventa\MainApp.java"]

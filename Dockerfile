# Usa una imagen ligera de Java para la ejecución
FROM openjdk:17-jdk-slim

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo .jar desde el host al contenedor
COPY target/*.jar api_convocatoria.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "api_convocatoria.jar"]

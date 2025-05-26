FROM openjdk:21-slim-bullseye

# Instala GCC y herramientas necesarias
RUN apt-get update && apt-get install -y gcc make \
 && rm -rf /var/lib/apt/lists/*

# Crea directorio para librerías JNI
RUN mkdir -p /usr/local/lib/jni

# Establece directorio de trabajo para compilar la librería
WORKDIR /usr/src/costolib

# Copia el archivo fuente C
COPY src/main/java/co/uceva/libcostos/lib/CostosProceso.h .
COPY src/main/java/co/uceva/libcostos/lib/costosproceso.c .

# Compila la librería compartida JNI
RUN gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" \
    -shared -o /usr/local/lib/jni/libcostosproceso.so costosproceso.c

# Cambia al directorio raíz para la app Java
WORKDIR /

# Variable que permite pasar el path del .jar en tiempo de build
ARG JAR_FILE=target/LibCostos-0.0.1-SNAPSHOT.jar

# Copia el jar generado
COPY ${JAR_FILE} app.jar

# Establece la ruta de las librerías nativas
ENV LD_LIBRARY_PATH=/usr/local/lib/jni

EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]


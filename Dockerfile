FROM openjdk:21

VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/LibCostos-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY libpronosticoventas.so /usr/local/lib/jni/
ENV LD_LIBRARY_PATH=/usr/local/lib/jni:$LD_LIBRARY_PATH
ENTRYPOINT ["java", "-jar","app.jar"]
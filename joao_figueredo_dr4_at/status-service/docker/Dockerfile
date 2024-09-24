FROM amazoncorretto:21
LABEL maintainer="joaofigueredo"
WORKDIR /app
COPY target/status-service-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
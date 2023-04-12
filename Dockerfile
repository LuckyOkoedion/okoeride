
FROM khipu/openjdk17-alpine

WORKDIR /app

COPY target/TheRide-0.0.1-SNAPSHOT.jar /app/TheRide.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/TheRide.jar"]

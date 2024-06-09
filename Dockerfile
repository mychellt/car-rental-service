FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/car-rental.jar /app/car-rental-service.jar

EXPOSE 8083

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/car-rental-service.jar"]


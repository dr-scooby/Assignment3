# Use Aline OS as base image with JDK 17
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the application JAR
COPY target/jismail3-0.0.1-SNAPSHOT.jar /app/jismail3.jar

# Expose the application port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "jismail3.jar"]
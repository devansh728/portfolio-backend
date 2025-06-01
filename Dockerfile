# Stage: Run only (assuming .jar already exists in target/)
FROM eclipse-temurin:17-jre

# Set working directory inside container
WORKDIR /app

# Copy your prebuilt jar into the container
COPY target/devansh-0.0.1-SNAPSHOT.jar app.jar
COPY .env .env

# Set active Spring profile (optional for staging)
ENV SPRING_PROFILES_ACTIVE=staging

# Optional: expose the port your app runs on
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

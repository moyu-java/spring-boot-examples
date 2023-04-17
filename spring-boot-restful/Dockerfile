FROM eclipse-temurin:17.0.6_10-jre-jammy
COPY target/*.jar /home/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-XX:MaxRAMPercentage=75.0", "/home/app/app.jar"]
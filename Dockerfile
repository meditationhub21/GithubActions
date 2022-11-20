FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/GithubActionsDemo-*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

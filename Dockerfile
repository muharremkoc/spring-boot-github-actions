FROM adoptopenjdk/openjdk17:alpine
EXPOSE 3132

COPY target/github-actions.jar github-actions.jar
ENTRYPOINT ["java","-jar","/github-actions.jar"]
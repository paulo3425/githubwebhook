FROM java:8
VOLUME /tmp
ADD target/githubwebhook-0.0.1-SNAPSHOT-jar-with-dependencies.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
FROM adoptopenjdk:11.0.11_9-jre-hotspot

WORKDIR  user-feature-manager

COPY build/libs/clock-0.0.1-SNAPSHOT.jar clock.jar

ENTRYPOINT ["java","-jar","clock.jar"]

EXPOSE 8080
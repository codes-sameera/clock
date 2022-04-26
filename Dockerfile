FROM adoptopenjdk:11.0.11_9-jre-hotspot

WORKDIR clock

COPY build/libs/clock-0.0.1-SNAPSHOT.jar clock.jar

ENTRYPOINT ["java","-jar","clock.jar","time"]

EXPOSE 8080
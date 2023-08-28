FROM gradle:8.3.0-jdk17-focal as build
LABEL authors="vasiliiparshkin"
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM ibm-semeru-runtimes:open-17.0.8_7-jdk-focal

RUN mkdir "/app"
COPY --from=build /home/gradle/src/build/libs/*.jar /app/test_task.jar
COPY --from=build /home/gradle/src/src/main/resources/properties/docker_logging.properties /app/logging.properties

#ENTRYPOINT ["java -Djava.util.logging.config.file=/home/gradle/src/resources/properties/docker_logging.properties ","-jar ", " /app/test_task.jar"]
ENTRYPOINT ["java","-Djava.util.logging.config.file=/app/logging.properties", "-jar", "/app/test_task.jar"]
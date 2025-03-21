FROM gradle:8.11.1-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon
RUN ls /home/gradle/src/build/libs #Adicionado para debug
RUN ls /home/gradle/src/build/libs/*.jar #Adicionado para debug

FROM openjdk:21-slim
COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
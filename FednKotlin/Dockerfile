ARG VERSION=11

FROM openjdk:${VERSION}-jdk as BUILD

COPY . ./src
WORKDIR /src
RUN ./gradlew jar

# FROM openjdk:${VERSION}-jre
FROM openjdk:22-slim-bullseye

COPY --from=BUILD /src/app/build/libs/ /app/
WORKDIR /app

CMD ["java", "-jar", "app.jar"]

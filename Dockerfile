ARG MAVEN_IMAGE=maven:3.9.6-eclipse-temurin-21
ARG JRE_IMAGE=eclipse-temurin:21-jre

FROM ${MAVEN_IMAGE} AS builder
WORKDIR /app

# copy pom first
COPY pom.xml .

# remove go-offline: mapstruct breaks with it
# RUN mvn dependency:go-offline -B

# copy sources
COPY src ./src

# build with annotation processors
RUN mvn clean package -DskipTests

FROM ${JRE_IMAGE} AS runtime
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

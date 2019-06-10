FROM openjdk:8

RUN mkdir /usr/src/myapp
COPY ../target/service-registry-1.0-SNAPSHOT.jar /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["java", "-jar", "-xms64m", "-xmx128m", "service-registry-1.0-SNAPSHOT.jar", "--spring.profiles.active=pro"]
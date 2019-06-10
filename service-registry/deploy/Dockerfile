FROM openjdk:8

RUN mkdir /usr/src/myapp
COPY ./service-registry-1.0-SNAPSHOT.jar /usr/src/myapp
WORKDIR /usr/src/myapp
#RUN chmod +x service-registry-1.0-SNAPSHOT.jar
CMD ["java", "-jar", "-xms64m", "-xmx128m", "service-registry-1.0-SNAPSHOT.jar", "--spring.profiles.active=pro"]
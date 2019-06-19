FROM openjdk:8

# 环境变量
ARG JAR_FILE

ENV WORK_PATH /usr/src/myapp

RUN mkdir $WORK_PATH

ADD target/${JAR_FILE} $WORK_PATH/app.jar

WORKDIR $WORK_PATH

CMD ["java", "-jar", "-Xms64m", "-Xmx128m", "app.jar", "--spring.profiles.active=pro"]
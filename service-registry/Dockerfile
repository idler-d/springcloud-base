FROM openjdk:8

# 环境变量
ENV WORK_PATH /usr/src/myapp
#ENV APP_NAME ${JAR_FILE}

RUN mkdir $WORK_PATH

COPY target/${JAR_FILE} $WORK_PATH

WORKDIR $WORK_PATH

CMD ["java", "-jar", "-xms64m", "-xmx128m", "app.jar", "--spring.profiles.active=pro"]
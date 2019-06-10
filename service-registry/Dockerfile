FROM openjdk:8

# 环境变量
ENV WORK_PATH /usr/src/myapp
ENV APP_NAME ${JAR_FILE}

RUN mkdir $WORK_PATH

RUN echo ${JAR_FILE}

COPY $APP_NAME $WORK_PATH/app.jar

WORKDIR $WORK_PATH

CMD ["java", "-jar", "-xms64m", "-xmx128m", "app.jar", "--spring.profiles.active=pro"]
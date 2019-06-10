FROM openjdk:8

# 环境变量
ENV WORK_PATH /usr/src/myapp
ENV APP_NAME ${JAR_FILE}

RUN mkdir $WORK_PATH

COPY $APP_NAME $WORK_PATH/app.jar

WORKDIR $WORK_PATH

CMD ["-jar", "-xms64m", "-xmx128m", "app.jar", "--spring.profiles.active=pro"]
FROM openjdk:17 as builder
COPY build/libs/base.jar /temp/base.jar
RUN java -Djarmode=layertools -jar /temp/base.jar extract --destination /extract/

FROM openjdk:17
ARG APP_HOME=/app
WORKDIR $APP_HOME
COPY --from=builder extract/dependencies/ $APP_HOME/
COPY --from=builder extract/application/ $APP_HOME/
COPY --from=builder extract/snapshot-dependencies/ $APP_HOME/
COPY --from=builder extract/spring-boot-loader/ $APP_HOME/

EXPOSE 800
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

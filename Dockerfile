# Copyright (c) 2020 PACS-SRE

FROM amazoncorretto:17.0.7-alpine

EXPOSE 8080

WORKDIR /var/lib/app/

COPY ./target/cci-service-*.jar ./cci-service.jar

RUN adduser -D app && chown app /var/lib/app

USER app

ENTRYPOINT ["java","-jar","./app.jar"]

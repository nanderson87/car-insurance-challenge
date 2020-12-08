FROM maven:3.6-ibmjava-8-alpine

COPY src /home/app/src
COPY pom.xml /home/app

RUN apk add --no-cache curl tar bash procps


CMD [""]
FROM openjdk:8
MAINTAINER kustrun

COPY ./target target
WORKDIR /

EXPOSE 8080
CMD PORT=8080 java -cp target/classes:target/dependency/* com.kumuluz.ee.EeApplication
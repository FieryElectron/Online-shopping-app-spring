FROM openjdk:11

EXPOSE 8080

COPY ./target/app??.jar /user/app/
WORKDIR /user/app

ENTRYPOINT [ "java", "-jar", "app??.jar" ]
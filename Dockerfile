FROM openjdk:11
WORKDIR /app
COPY ./target/ParkingControll-0.0.1-SNAPSHOT.jar ./application.jar
EXPOSE 8080


ENTRYPOINT java -jar application.jar
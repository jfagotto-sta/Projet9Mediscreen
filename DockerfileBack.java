FROM openjdk:17-alpine

        COPY target/projet9-0.0.1-SNAPSHOT.jar patient.jar



        ENTRYPOINT ["java", "-jar", "patient.jar"]
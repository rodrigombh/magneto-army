# MagnetoArmy

How to start the MagnetoArmy application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/magneto-army-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Stack
---

- Java
- Dropwizard (Principales: Jetty, Jersey, JUnit, Mockito)
- DynamoDB

Hosting:
---

- AWS


API
---

GET 	/magneto-army/stats

POST 	/magneto-army/mutant
Example: {"dna":["ATG","CAG","TTA"]}
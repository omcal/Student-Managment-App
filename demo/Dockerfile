FROM  maven:3.8.1-openjdk-17-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/demo.jar"]

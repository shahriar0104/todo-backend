FROM openjdk:11
EXPOSE 5019
ADD target/todo-backend-docker.jar todo-backend-docker.jar
ENTRYPOINT ["java","-jar","/todo-backend-docker.jar"]
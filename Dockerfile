FROM openjdk:11
EXPOSE 8003
ADD target/todo-backend-docker.jar todo-backend-docker.jar
ENTRYPOINT ["java","-jar","/todo-backend-docker.jar"]
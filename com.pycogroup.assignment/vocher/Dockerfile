# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="hieunt1912@gmail.com"

# Add a volume pointing to /tmp
#VOLUME /tmp

# Make port 8085 available to the world outside this container
EXPOSE 8887

# The application's jar file
ARG JAR_FILE=target/vocher-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} vocher-1.0.0.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/vocher-1.0.0.jar"]
# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

# copy the pom and src code to the container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src


# package our application code
RUN mvn clean package


# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:8-jre-alpine3.9

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/sonarqube-0.0.1-SNAPSHOT.jar /sonarqube.jar


ADD ADEO_ROOT_CA1.crt /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/ADEO_ROOT_CA1.crt

RUN \
cd $JAVA_HOME/lib/security \
&& keytool -import -alias ca -file ADEO_ROOT_CA1.crt -keystore cacerts -storepass changeit -noprompt

# set the startup command to execute the jar
CMD ["java", "-jar", "/sonarqube.jar"]
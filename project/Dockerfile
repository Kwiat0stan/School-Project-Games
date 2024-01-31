# Use an official OpenJDK image with the full JDK
FROM openjdk:11

# Set path to dir where is file that you want to test / execute
WORKDIR /Users/wojciechk/Developer/School-Project-Games/project

# Path where you build image
COPY /Users/wojciechk/Developer/School-Project-Games/project .

# Compile the Java code
RUN javac **/*.java

# Run the Java application
CMD ["java", "Main"]
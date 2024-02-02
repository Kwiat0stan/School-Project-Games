# Pull base image
# Use an official OpenJDK image with the full JDK
FROM openjdk:21-jdk

# Create new dir called app inside container for my application files
# RUN executes commands for image 
RUN mkdir /app

# Copy application files into image filesystem
COPY . /app

# Set the dir for executing future commands RUN
WORKDIR /app

RUN javac -d . Main.java Server.java childGames/*.java parentsGames/*.java test/*.java

# Command that will start the container from the image
# It can be only one command or ENTRYPOINT instuction
# F.e this one launch application where you start the container
# second var -> specify package with File class at the end

# Select one depends what image you want to create

# CMD [ "java", "project.test.Test" ]
# CMD [ "java", "project.Main" ]
CMD [ "java", "project.Server" ]
# Ride Sharing Application

This is a ride sharing application with REST API and Websocket endpoints. The REST API endpoints will be available at the swagger ui documentation `http://localhost:8080/swagger-ui/index.html#/` path after startup. But the websocket endpoint though it will not be on the documentation, it will be listening for connection at `http://localhost:8080//websocket/`. The websocket endpoint is for the web app to broadcast location data which will later go upstream to kafka and cassandra DB for intensive read and writes for real-time awareness and future analytics respectively.

## Version Requirement
Java SE 17 or later

# HOW TO RUN


## Build the docker image

docker build -t theride:latest .

## Run the kubernetes deployment


## Build

Run at the base of application:

mvn clean install -DskipTests

## Run

Start like any other springboot application




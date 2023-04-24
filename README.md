# Ride Sharing Application

This is a ride sharing application with REST API and Websocket endpoints. The REST API endpoints will be available at the swagger ui documentation `http://localhost:8080/swagger-ui/index.html#/` path after startup. But the websocket endpoint though it will not be on the documentation, it will be listening for connection at `ws://localhost:8080/ws/`. The websocket endpoint is for the web app to broadcast location data which will later go upstream to kafka and cassandra DB for intensive read and writes for real-time awareness and future analytics respectively.

## Version Requirement
Java SE 17 or later

# HOW TO RUN


## Build install dependencies, compile and run tests

mvn clean install

## Start zookeeper and kafka (You should have docker installed, up and running)

docker-compose -f ./kafka-docker-compose.yaml -p the_ride up


## Start Cassandra DB

docker-compose -f ./cassandra-docker-compose.yaml -p the_ride up

cqlsh

CREATE KEYSPACE the_ride WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};

## Build docker Image

docker build -t the-ride-api:latest .

## Update Config-map-kube.yaml with the correct IPs for db and kafka and apply
kubectl apply -f config-map-kube.yaml

## Create Kubernetes deployment
kubectl apply -f api-kube.yaml

## Create service for external access
kubectl apply -f api-service-kube.yaml

## ACCESS API HERE (If using kubernetes on mac docker desktop)

http://kubernetes.docker.internal:30080/swagger-ui/index.html





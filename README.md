# light-microservice-base

Jdk 1.8
Maven 4
Docker swarm

mvn clean install

docker build --build-arg PORT=9094 --build-arg JAR_FILE=light-microservice-base-1.0.jar -t light-microservice-base:1.0 -f docker/Dockerfile .

docker stack deploy -c docker/docker-compose.yml microservices

http://localhost:9094/api/v1/health

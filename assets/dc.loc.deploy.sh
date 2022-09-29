NAME='api-imdb-videogames'

./gradlew clean ktlintCheck assemble

docker build --rm -t $NAME .

docker-compose -f assets/docker-compose.yaml down
docker-compose -f assets/docker-compose.yaml up
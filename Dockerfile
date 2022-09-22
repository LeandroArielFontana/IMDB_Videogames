FROM adoptopenjdk/openjdk11:alpine
LABEL name=api-imdb-videogames
EXPOSE 8080

RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
RUN mkdir -p /opt/api-imdb-videogames && chown javauser:javauser /opt/api-imdb-videogames

WORKDIR /opt/api-imdb-videogames
USER javauser

COPY build/libs/*.jar /opt/api-imdb-videogames/

CMD ["java", "-jar", "api-imdb-videogames-1.0.0-SNAPSHOT.jar" ]

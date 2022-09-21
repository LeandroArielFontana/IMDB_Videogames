FROM adoptopenjdk/openjdk11:alpine
LABEL name=api-imdb-videogame
EXPOSE 8080

RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
RUN mkdir -p /opt/api-imdb-videogame && chown javauser:javauser /opt/api-imdb-videogame

WORKDIR /opt/api-imdb-videogame
USER javauser

COPY build/libs/*.jar /opt/api-imdb-videogame/

CMD ["java", "-jar", "api.jar" ]

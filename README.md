# IMDB Videogames

### para crear la carpeta build

```
./gradlew build
```

### para crear el .jar

```
./gradlew bootJar
```

### para buildear la imagen de docker

```
Docker build .
```

### para poder levantar un contenedor en detouch con la imagen de la api

````
docker run -d -p 8080:8080 --name aplicacion api-imdb-videogames
````

### para crear el contenedor de la DB (MySQL)

```
docker-compose -f assets/docker-compose.yaml up -d
```

### Acceder a la base de datos

para poder acceder a la consola de la base de datos que 
esta en el contedor assets-mysqldb-1 se realiza el siguiente comando

````
docker exec -ti assets-mysqldb-1 bash 
````
### Creacion del directorio

Para poder pasar el archivo .csv que contiene los datos para la base, 
primero hay que crear el directorio con el siguiente comando.

```shell
mkdir database
```

podemos verificar si el directorio fue creado correctamente con el siguiente comando.

````shell
ls -a
````

### Copiar csv al contenedor (HACERLO CON CMD YA QUE BASH TIRA UN ERROR)

para poder copiar el archivo al contenedor se tiene que correr 
el siguiente comando indicando la ruta de ubicacion del archivo local 
y la ruta del contenedor de donde va a estar ubicado

```docker
docker cp D:\Programacion\videogames\src\main\resources\imdb-videogames.csv assets-mysqldb-1:/database
```

Mismo que en el paso anterior podemos verificar si el archivo .csv
fue copiado correctamente con el siguiente comando primero 
ingresando a su directorio y luego viendo que archivos contiene esa carpeta.

````shell
cd database
````

```shell
ls -a
```

### Ingresar a la base de datos

Para poder ingresar a la base de datos tenemos que colocar
el nombre de usuario y la contraseña, por defecto ambas son root

````
mysql -uroot -proot
````

### Creacion de la base de datos MySQL

El paso siguiente para poder ejecutar la API con Docker es verificar 
si la base de datos esta creada con el siguiente comando.

```
SHOW DATABASES;
```

En el caso de que no este creada, utilizar el siguiente comando:

```
CREATE DATABASE videogames;
```

Ahora lo que haremos es decirle a MySQL que utiliaremos la base de 
datos especificada con el siguiente comando:

```
USE videogames;
```

Acto siguiente creamos las tablas para la base de datos 
anteriormente mencionada

```
CREATE TABLE videogame(
Id INT PRIMARY KEY,
Name varchar(100),
Url varchar(255),
Year int,
certificate varchar(255),
Rating double,
Votes varchar(20),
Plot varchar(20), 
Action varchar(5),
Adventure varchar(5), 
Comedy varchar(5), 
Crime varchar(5),
Family varchar(5), 
Fantasy varchar(5),
Mystery varchar(5), 
Sci_Fi varchar(5), 
Thriller varchar(5)
);
```

### Insertar datos en la base de datos del contenedor 

Para poder insertar los datos a nuestra base de datos se corre el siguiente comando:

```
load data local infile 'database/imdb-videogames.csv' into table videogame fields terminated by ',' lines terminated by '\n';
```

* Nota: Para poder insertarlos, no tenemos que estar parados 
en la carpeta database, si no que en la misma raiz del contenedor

### Crear configuracion dentro de MySQL

Creacion de la configuracion de MySQL dentro del contenedor para poder hacer
la conexion de manera exitosa, para esto se le otorgaran todos los privilegios
al nuevo usuario creado. Para esto se ejecutan los siguientes comandos 
siempre en el shell de MySQL del contenedor corriendo

```
CREATE USER imdbdatabase@localhost IDENTIFIED BY 'imdbvideogames';

GRANT ALL PRIVILEGES ON *.* TO imdbdatabase@localhost WITH GRANT OPTION;

CREATE USER imdbdatabase@'%' IDENTIFIED BY 'imdbvideogames';

GRANT ALL PRIVILEGES ON *.* TO imdbdatabase@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;
```

### Correr la API

Una vez que configuramos todo, podremos salir de MySQL colocando:

```
exit
```

Podremos salir del contenedor con el mismo comando, acto seguido podemos
correr la API y verificar con postman alguno de los endpoints para verificar
que los datos son entregados con exito por nuestra API
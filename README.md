# Greeting application

  In a basic Dockerized Springboot Maven application, developed a single REST endpoint GET /greeting which behaves in the following manner:
1. Given the following input values account=personal and id=123 
and the allowable values for account are personal and business
and the allowable values for id are all positive integers
then return "Hi, userId 123".
2. Given the following input values account=business and type=small and 
and the allowable values for account are personal and business
and the allowable values for type are small and big
then return an error that the path is not yet implemented.
3. Given the following input values account=business and type=big and 
and the allowable values for account are personal and business
and the allowable values for type are small and big
then return "Welcome, business user!".

### Features
It should be able to:
- build application with Maven
- build the Docker image and run it
- make a request to localhost:5000/greeting and verify the behavior

### Tech

This application uses spring boot framework, maven as build tool and docker container.

### Installation

This application requires Spring boot, maven and docker login to run.
Start the dockerized spring boot maven app with commands given below.
Below commands will build project using maven and build docker image push it to respository. 
And it will run the image. Then we can check `http://localhost:5000/greeting` endpoint 
to verify behavior.

```sh
$ cd greeting
$ mvn install
$ docker push triveni1990/greeting:0.0.1-SNAPSHOT
$ docker run -t triveni1990/greeting:0.0.1-SNAPSHOT
```

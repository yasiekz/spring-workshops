# Spring-Workshops

## Preparing

### You need to install:

- MongoDb `sudo apt-get install mongodb`
- Robomongo - this is the app in which we will check our db `https://robomongo.org/download`
- clone repository `git@github.com:yasiekz/spring-json-for-test.git` and follow instructions in its readme

### Configuration

- Run robomongo and create default connection at localhost:27017
- Add database java-workshops

## Agenda

- Spring and dependency injection (but only some easy examples)
- Morphia - what is it, and its adoption for spring
- TopStory entity with some Morphia Annotations
- Support mongoDb indexes using Morphia (and why mapping entities is so necessery)
- GSon - json transformer from google + excluding fields from gson (transient or @Expose and diff between them)
- TopStory repository with save, and some get methods.
- TopStoryDTO from json with TopStoryDTORepository
- Photo and Video entity
- Handling collections with Morphia
- Finally refreshing TopStory object

*Good luck Marciny and others ducks* 

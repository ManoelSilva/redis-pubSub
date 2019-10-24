# Redis PubSub with RPUSH and RPOP - Spring boot simple implementation

This project has 2 simple systems, both connected to redis. One produce messages and publish at redis, and the other consumes these messages and write them in a hsql database.

## Run project

* Install docker https://www.docker.com

At root folder, where docker-compose.yml file is located, run the following commands:

* docker-compose build
* docker-compose up -d

## API Endpoints

### Publish message

* http://localhost:8083/pub/
    * `method`: POST
* response:
```json
    {
        "success": true,
        "message": "Message generated with random UUID: cb897567-4452-4662-bbd2-8f465ce707a2"
    }
```

## APP Web

* http://localhost:8084/sub

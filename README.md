# Chat Bot Mother

 Server for thin chatbot clients.

 Receives requests, process them and return unified response.

## Build
- Install [http://maven.apache.org/install.html](Maven)
- Run in root folder `mvn -e package`
- Compiled <filename>-jar-with-dependencies.jar and `config.properties` file will be in `target` folder

## Run
- Edit file `config.properties`
- Run `java -jar <filename>-jar-with-dependencies.jar`

## Clients

- https://github.com/garf/telegram-bot-thin
- https://github.com/garf/slack-bot-thin
- https://github.com/garf/facebook-bot-thin

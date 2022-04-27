# clock
Simple application that outputs the time in a human format- i.e., in words

### Features
- CLI for returning the current time as "Human Friendly Text" **(Objective 1)**
- CLI for returning an arbitrary Numeric Time as "Human Friendly Text" **(Objective 2)**
- REST API for returning the current time/ arbitrary Numeric Time as "Human Friendly Text" **(Objective 3)**
- Human Friendly text examples:
  - 1:00 One o'clock in the morning.
  - 2:00 Two o'clock in the morning.
  - 13:00 One o'clock in the afternoon.
  - 13:05 Five past one in the afternoon.
  - 13:10 Ten past one in the afternoon.
  - 13:25 Twenty five past one in the afternoon.
  - 13:30 Half past one in the afternoon.
  - 13:35 Twenty five to two in the afternoon.
  - 13:55 Five to two in the afternoon.
- **Note: Added the phrase** - in the afternoon/evening/morning as appropriate in addition to the requirements

### API documentation
The user-feature-manager exposes the following APIs:

![](images/api.png?raw=true "Title")

### Running and using the app
- The easiest way to get the service up is by running the docker 
  - ```docker run sameeracodes/clock``` - prints the current time to the console
  - ```docker run sameeracodes/clock -n <hh>:<mm>``` - prints the arbitrary Numeric Time to the console
- Alternatively, the jar can be build after downloading the source using - ```gradlew build```, and then executed
- Alternatively, ```gradlew bootrun``` can also be executed after downloading the source
- API Documentation is available at http://localhost:8080/clock/swagger-ui/index.html
  - Hit the http://localhost:8080/clock/time to get the current time as response
  - Hit the http://localhost:8080/clock/time?t=<hh>:<mm> to get the arbitrary Numeric Time as response
- CLI Documentation - 
  ```
    Usage: clock-cli [command] [command options]
    Commands:
    time      Time command, displays time (current or optionally input in
            numeric format) in human readable format
      Usage: time [options]
        Options:
          --numeric-format-input, -n
            Time in numeric 24 hour format - Ex. 14:35
  ```
### Error Responses
- The CLI prints a valid error message on to the console and the application **does not** exit on invalid inputs.
- The REST API responds with an ```ErrorMessage``` object on invalid input

### Developer Notes
- JavaDocs are added for every public class that can be used as an API
- **The CI**
    - Builds on every commit to the master and on every pull request to the master
    - Executes gradle build, i.e., compilation and unit tests
    - Builds a **docker image** and publishes to a repository in docker hub; this image can be used to deploy the app
- Aspect **(Spring AOP)** is used for logging API calls made to the application and debug logs in all the methods
- **Lombok** is used to avoid boilerplate code
- **Openapi Swagger** is used for API documentation
- **JCommander** is used to create the command line 
- **Extendability-** Care is taken to make the code as extendable as possible. 
    - For example: Implementing a new Human readable date, would require addition of a command class and a command controller and the business logic.
- ##### TO DO:
    - add integration tests
    - optimize docker creation using layered jar

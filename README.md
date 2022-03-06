# Spring-boot-app
Milos Petrovic

1. git clone https://github.com/Shamyx1/Spring-boot-app
2. open project in IDE
3. set configuration to maven -> command line: spring-boot:run
4. set maven build in IDE
5. set system env's if needed
6. run application

Profiles:
default (test)
dev
ext

URL's:
/ - index page
/all - shows all languages & words
/hello-rest - shows String "Hello World"
/hello - shows HTML page with "Hello World"
/hello/English - get word in english
/secure-hello - login page
/hello?input=word&target=lang - works on ext profile, returns 403 Forbidden for token (should translate word, parameters input=zdravo&target=eng) - needs Postman

Port: 8080

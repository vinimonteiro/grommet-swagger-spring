# grommet-swagger-spring

A wrapper around grommet-swagger (https://github.com/grommet/grommet-swagger)
to facilitate integration with SpringBoot applications using tools that generate OpenAPI documentation. 
Such as: Springdocs (https://springdoc.org/) or Springfox-swagger2 (https://springfox.github.io/springfox/docs/current/)

It's an alternative to Swagger-UI.
It works with Springdocs generated url by default. For other tools, the OpenAPI doc path must be defined in application.properties file.

Steps to use in your application (assuming it uses Springdocs already):
- Download the fat jar available in master branch (https://github.com/vinimonteiro/grommet-swagger-spring/blob/master/grommet-swagger-spring-0.0.1-packaged.jar)
- Install the jar in your local maven repository. You can use for example maven-install-plugin in pom.xml

The documentation can be viewed by accessing application url / grommet-swagger. For example: http://localhost:8080/<context path>/grommet-swagger.
/grommet-swagger redirects to controller, which then it passes url, theme, routePrefix etc to grommet-swagger.html

Parameters can be defined in application.properties. See details there.

See this application that uses grommet-swagger-spring: https://github.com/vinimonteiro/product-service-grommet-swagger



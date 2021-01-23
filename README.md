# grommet-swagger-spring

A wrapper around grommet-swagger (https://github.com/grommet/grommet-swagger)
to facilitate integration with SpringBoot applications using tools that generate OpenAPI documentation. 
Such as: Springdocs (https://springdoc.org/) or Springfox-swagger2 (https://springfox.github.io/springfox/docs/current/)

It's an alternative to Swagger-UI. 

It works with Springdocs generated url by default. For other tools, the OpenAPI doc path must be defined in application.properties file.

Steps to use in your application (assuming it uses Springdocs already):
1 - Download the fat jar available in master branch
2 - Install the jar in your local maven repository. You can use for example maven-install-plugin in pom.xml
3 - Configure to scan the controller using: @ComponentScan("com.grommet"). Once you do that, you need also to configure to scan your controllers. 
(I'm still looking for some way to not need to do that. Feel free to propose some change)

The documentation can be viewed by accessing application url / grommet-swagger. For example: http://localhost:8080/<context path>/grommet-swagger.
/grommet-swagger redirects to controller, which then it passes url, theme, routePrefix etc to grommet-swagger.html

Parameters can be defined in application.properties. See details there.




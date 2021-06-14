## HATEOAS

(draft)

HATEOAS: Hypermedia as the Engine of Application State

[HAL - Hypertext Application Language](https://stateless.group/hal_specification.html)


spring-data-rest already did everything for us.
Or we can use spring-boot-starter-hateoas to implement the logic. 

If you are using spring-data-rest, you can set `spring.data.rest.base-path` in the property file to change your apis' base path.

```yml
spring:
  data:
    rest:
      base-path: /data-rest-api
```

### 参考

* [An Intro to Spring HATEOAS](https://www.baeldung.com/spring-hateoas-tutorial)
* [HATEOAS for a Spring REST Service](https://www.baeldung.com/rest-api-discoverability-with-spring)

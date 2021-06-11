## Enum Persisting

参考：

* [https://www.baeldung.com/jpa-persisting-enums-in-jpa](https://www.baeldung.com/jpa-persisting-enums-in-jpa)
* [https://qiita.com/Hisashi-Yamauchi/items/2b8823d84728854e094b](https://qiita.com/Hisashi-Yamauchi/items/2b8823d84728854e094b)
* [https://www.ne.jp/asahi/hishidama/home/tech/java/spring/boot/jpa/jpql.html](https://www.ne.jp/asahi/hishidama/home/tech/java/spring/boot/jpa/jpql.html)

### Using @Enumerated(EnumType) on enum field

* EnumType.ORDINAL persist as an integer
* EnumType.STRING persist as as string

Very simple if you will never intend to change the definition of the enums.

### Using JPA callback @PostLoad @PrePersist

* @PrePersist callback before persisting, which specifies how to map the enum to db value
* @PostLoad callback after reading from db, which maps the db value back to enum

You need to define two separate filed in the entity.

### Using JPA Converter

create a custom Converter which implements javax.persistence.AttributeConverter. Compatible with JPQL.

About JPQL: [https://www.baeldung.com/spring-data-jpa-query](https://www.baeldung.com/spring-data-jpa-query)

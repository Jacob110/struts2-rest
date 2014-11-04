# Struts2 Restful Webservice

---
本例子是使用 `struts2-rest-plugin` 和 `struts2-convention-plugin` 构建的 `restful`风格的 `webservice`
使用的插件:
>* `struts2-rest-plugin` 版本 `2.3.16`
>* `struts2-convention-plugin` 版本 `2.3.16`
>* `struts2-config-browser-plugin` 版本 `2.3.16`
>* `log4j` 版本 `2.0.2`

其他插件见`pom.xml`

    <properties>
        <java-version>1.6</java-version>
        <struts2.version>2.3.16.3</struts2.version>
        <spring.version>4.1.1.RELEASE</spring.version>
        <mybatis.version>3.2.8</mybatis.version>
        <hibernate.version>4.3.6.Final</hibernate.version>		
    </properties>
实现了 `struts` 框架中集成 `rest`，使用 `restful` 风格 `url` 访问 `action`，同时将普通非 `rest` 风格的 `action` 与 `rest` 风格 `action` 共存。比如：
>* `rest action` 访问: `http://localhost:8080/struts-rest-example/restful/login`
>* 普通`action`访问: `http://localhost:8080/struts-rest-example/hello`


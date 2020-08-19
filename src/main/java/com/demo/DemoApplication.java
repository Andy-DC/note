package com.demo;

import org.apache.catalina.connector.Connector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@MapperScan("com.demo.mapper")
//@EnableDiscoveryClient
//@EnableResourceServer
//导入配置文件
//@ImportResource("classpath:/spring/spring-rabbitmq.xml")
public class DemoApplication {
//    @EnableResourceServer
//    请求优先由@EnableAuthorizationServer、@EnableResourceServer 处理，剩下的无法匹配的由SpringSecurity处理。
    //EnableDiscoveryClient
    //@EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到改服务。
    //
    //不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * SpringBoot 2.0.0 以上都采用内置tomcat8.0以上版本，
     * 而tomcat8.0以上版本遵从RFC规范添加了对Url的特殊字符的限制，
     * url中只允许包含英文字母(a-zA-Z)、数字(0-9)、-_.~四个特殊字符
     * 以及保留字符( ! * ’ ( ) ; : @ & = + $ , / ? # [ ] ) (262+10+4+18=84)这84个字符,
     * 请求中出现了{}大括号或者[],所以tomcat报错。设置RelaxedQueryChars允许此字符(建议)，
     * 设置requestTargetAllows选项(Tomcat 8.5中不推荐)。 根据Tomcat文档，下面提供一种方法来设置松弛的QueryChars属性*
     * @return
     *
     *
     * 以下代码是发送短信接口报错，异常因袭为
     * Invalid character found in the request target. The valid characters are defined in RFC 7230 and RFC 3986
     * 在请求目标中发现无效字符。有效字符在RFC 7230和RFC 3986中定义
     * 请求中出现了{}大括号或者[],所以tomcat报错
     * https://blog.csdn.net/qq_41291945/article/details/105126610
     *
     *
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("relaxedQueryChars", "|{}[]");
            }
        });
        return factory;
    }


}

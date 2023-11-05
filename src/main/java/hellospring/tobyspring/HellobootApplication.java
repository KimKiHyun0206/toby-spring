package hellospring.tobyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootAnnotation
public class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

//    public static void main(String[] args) {    //처음 스프링부트가 만들어준 코드와 같다 -> 지금까지 한 게 스프링부트가 스프링 코드를 만들어주는 방법이다
//        MySpringApplication.run(HellobootApplication.class, args);
//    }
}
package hellospring.tobyspring;

import org.springframework.boot.SpringApplication;

@MySpringBootAnnotation
public class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

//    public static void main(String[] args) {    //처음 스프링부트가 만들어준 코드와 같다 -> 지금까지 한 게 스프링부트가 스프링 코드를 만들어주는 방법이다
//        MySpringApplication.run(HellobootApplication.class, args);
//    }
}
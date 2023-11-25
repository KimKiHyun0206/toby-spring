package hellospring.tobyspring.helloboot;

import hellospring.tobyspring.config.MySpringBootAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@MySpringBootAnnotation
public class HellobootApplication {
    /*@Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            String name = environment.getProperty("my.name");
            System.out.println("my.name : " + name);
        };
    }*/

    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PostConstruct
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");

    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

//    public static void main(String[] args) {    //처음 스프링부트가 만들어준 코드와 같다 -> 지금까지 한 게 스프링부트가 스프링 코드를 만들어주는 방법이다
//        MySpringApplication.run(HellobootApplication.class, args);
//    }
}
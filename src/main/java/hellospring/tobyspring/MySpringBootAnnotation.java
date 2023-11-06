package hellospring.tobyspring;

import hellospring.tobyspring.config.EnableMyAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan
@EnableMyAutoConfiguration  //구성 정보에 클래스 정보 넘겨서 추가하기
public @interface MySpringBootAnnotation {
}

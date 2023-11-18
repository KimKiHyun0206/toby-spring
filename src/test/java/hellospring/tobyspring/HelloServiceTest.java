package hellospring.tobyspring;

import hellospring.tobyspring.helloboot.HelloDecorator;
import hellospring.tobyspring.helloboot.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest{    //이렇게 하면 Test를 따로 할 수 있는 메타 애노테이션이 만들어진다

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest{    //메타애노테이션은 재귀가 가능하다

}


public class HelloServiceTest {

    @Test
    void simpleHelloServiceTest(){
        SimpleHelloService helloService = new SimpleHelloService();

        String response = helloService.sayHello("Test");

        Assertions.assertThat(response).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String response = decorator.sayHello("Test");
        Assertions.assertThat(response).isEqualTo("* Test *");
    }
}

package hellospring.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

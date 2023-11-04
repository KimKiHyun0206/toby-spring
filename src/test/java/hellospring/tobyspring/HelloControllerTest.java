package hellospring.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);
        //아래는 위와 같은 코드임
//        HelloController helloController1 = new HelloController(new HelloService() {
//            @Override
//            public String sayHello(String name) {
//                return name;
//            }
//        });

        String response = helloController.hello("Test");

        Assertions.assertThat(response).isEqualTo("Test");

    }

    @Test
    void failHelloController() {
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(() -> {
            String response = helloController.hello(null);  //여기서 예외 발생함
        }).isInstanceOf(IllegalArgumentException.class);    //NullPointerException 이 발생한 경우에만 테스트가 성공한다
    }

    @Test
    void failHelloController2(){
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(()->{
            String response = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

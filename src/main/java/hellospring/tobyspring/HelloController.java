package hellospring.tobyspring;

import java.util.Objects;

public class HelloController {
    private final HelloService helloService;

    // 생성자를 통해 Bean을 만들 때 어떤 것이 필요한지 알려준다
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}

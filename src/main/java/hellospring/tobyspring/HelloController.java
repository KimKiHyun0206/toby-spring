package hellospring.tobyspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody   //String이 리턴되면 view로 받아들이기 때문에 ~~.html 파일을 반환하지 않아도 되도록 해주는 애노테이션
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}

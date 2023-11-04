package hellospring.tobyspring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
    private final HelloService helloService;
    private ApplicationContext applicationContext;

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {  //생성자를 이용해서 주입하는 방법
        this.helloService = helloService;
        this.applicationContext = applicationContext;
    }

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    //@ResponseBody   //String이 리턴되면 view로 받아들이기 때문에 ~~.html 파일을 반환하지 않아도 되도록 해주는 애노테이션
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }

    /*  implements ApplicationContextAware
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);     //Root WebApplicationContext, started on Sat Nov 04 09:48:42 KST 2023 정상적으로 작동
        this.applicationContext = applicationContext;
    }
    */
}

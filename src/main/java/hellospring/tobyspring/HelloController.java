package hellospring.tobyspring;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    //@ResponseBody   //String이 리턴되면 view로 받아들이기 때문에 ~~.html 파일을 반환하지 않아도 되도록 해주는 애노테이션
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name);
        //return helloService.sayHello(Objects.requireNonNull(name));
    }

    /*  implements ApplicationContextAware
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);     //Root WebApplicationContext, started on Sat Nov 04 09:48:42 KST 2023 정상적으로 작동
        this.applicationContext = applicationContext;
    }
    */
}

package hellospring.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class TobyspringApplication {
//test
    //
    public static void main(String[] args) {
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();   //dispactherServlet 때문에 변경함
        applicationContext.registerBean(HelloController.class);
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.refresh();


        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                    /*DispatcherServlet 이 매칭을 하다가 작업을 위임함
                    요청을 디스패치할 오브젝트를 찾아야되는데 그때 사용할 ServletContainer 를 전달해줌*/
                    new DispatcherServlet(applicationContext)
            ).addMapping("/*");
        });
        webServer.start();
    }

}

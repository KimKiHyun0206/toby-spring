package hellospring.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TobyspringApplication {

    public static void main(String[] args) {
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    //쳐청을 할 때 파라미터가 있다면 그 파라미터를 변수로 사용할 것이다
                    String name = req.getParameter("name");

                    resp.setStatus(HttpStatus.OK.value());                                       //상태 코드
                    resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);  //헤더
                    resp.getWriter().println("hello" + name);                //바디
                }
            }).addMapping("/hello");
        });
        webServer.start();
    }

}

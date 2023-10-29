package hellospring.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
            HelloController helloController = new HelloController();
            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    //인증, 보안, 다국어, 공통 기능을 모두 구현했다고 가정함
                    //기존에는 URL을 매칭해서 Servlet Container가 Servlet에게 요청을 위임했다.
                    //이제는 그 역할을 이 프론트 컨트롤러에서 해줄 수 있어야 한다

                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        String name = req.getParameter("name");

                        //메소드를 호출할 때 인자값으로 넘겨주는 작업을 바인딩이라고 한다
                        //dto로 데이터를 넘기는 것도 바인딩이라고 한다(사실은 이것보단느 복잡하다)
                        String ret = helloController.hello(name);   //바인딩

                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
                    } else if (req.getRequestURI().equals("/uesr")) {

                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");    //모든 url을 여기서 처리할 것이다
        });
        webServer.start();
    }

}

package hellospring.tobyspring;

import org.apache.coyote.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloApiTest {

    @Test
    void helloApi() {   //Spring을 실행해야 제대로 테스트가 진행됨
        //http localhost:8080/hello?name=Spring
        //Httpie 라고 부르기를 개발자들이 요청한다(터미널)

        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> response =
                rest.getForEntity(
                        "http://localhost:8080/hello?name={name}",
                        String.class,
                        "Spring"
                );
        //status code 200
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        //header(content-type) test/plain
        Assertions.assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        //body Hello Spring
        Assertions.assertThat(response.getBody()).isEqualTo("* Hello Spring *");
    }

    @Test
    void failHelloApiTest(){
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> response =
                rest.getForEntity("http://localhost:8080/hello?name=", String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

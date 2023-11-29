package hellospring.tobyspring;

import hellospring.tobyspring.helloboot.HelloRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
* @SpringBootTest 우리가 만든 DB를 초기화하는 루틴이 필요하여 사용한다
 * @webEnvironment=SpringBootTest.WebEnvironment.NONE 빈들을 컨테이너로 로딩하는데 굳이 이 테스트를 돌리는 동안에 웹 환경을 세팅할 필요는 없다
 *
* */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloFailed(){
        Assertions.assertThat(helloRepository.findHello("Toby")).isNull();

    }

    @Test
    void increaseCount(){
        Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(0);

        helloRepository.increaseCount("Toby");
        Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(1);

        helloRepository.increaseCount("Toby");
        Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(2);
    }
}

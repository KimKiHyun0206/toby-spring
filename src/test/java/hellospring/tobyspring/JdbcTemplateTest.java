package hellospring.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HellobootTest
public class JdbcTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;


    /*
    * 테스트를 시작할 때 DB를 초기화하는 작업
    * 종료될 때 그 모든 DB의 내용이 사라진다
    * 메모리에서만 돌아가기 때문이다
    * */
    @BeforeEach
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery1(){
        jdbcTemplate.update("insert into hello values(?, ?)", "Toby", 3);
        jdbcTemplate.update("insert into hello values(?, ?)", "spring", 1);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        Assertions.assertThat(count).isEqualTo(2);
    }

//    @Test     //두 개의 테스트를 모두 돌렸을 때 오류가 나지 않는다. 왜냐하면 테이블이 드롭되어 새로운 테이블로 실행하기 때문이다 . 원래 테이블이 드롭되지 않으면 4가 나와야 한다
//    void insertAndQuery2(){
//        jdbcTemplate.update("insert into hello values(?, ?)", "Toby", 3);
//        jdbcTemplate.update("insert into hello values(?, ?)", "spring", 1);
//
//        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
//        Assertions.assertThat(count).isEqualTo(2);
//    }
}

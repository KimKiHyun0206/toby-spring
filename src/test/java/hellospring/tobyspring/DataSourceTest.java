package hellospring.tobyspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ExtendWith
 * JUnit5의 테스트를 조금 확장하는 것이다
 * 여기에 SpringExtension.class를 넣으면 SpringContext를 이용하는 SpringContainer 테스트가 가능하다
 * @ContextConfiguration
 * 어디서 빈 정보를 가져올지 결정하는 것이다
 * 그리고 HellobootApplication 은 모든 빈의 정보를 가지고 있다
 * import, Component Scan을 이용해서 자동 구성 빈, 애플리케이션 빈 등을 모두 불러올 수 있다
 * @TestPropertySource
 * 테스트용으로 프로퍼티 정보를 가져올 수 있게 해주는 것이다
 * Classpath를 지정해줘서 야기서 읽어오라고 지정해준 것이다
*/



@JdbcTest
public class DataSourceTest {
    @Autowired
    DataSource dataSource;

    @Test
    void connect() throws SQLException{
        Connection connection = dataSource.getConnection();
        connection.close();
        /*
        20:23:59.150 [Test worker] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Starting...
        20:23:59.401 [Test worker] DEBUG com.zaxxer.hikari.pool.HikariPool - HikariPool-1 - Added connection conn0: url=jdbc:h2:mem: user=SA
        20:23:59.407 [Test worker] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Start completed.
        */
    }
}
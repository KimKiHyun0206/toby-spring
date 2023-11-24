package hellospring.tobyspring.helloboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hello findHello(String name) {
        try{
            return jdbcTemplate.queryForObject("select * from hello where name ='" + name + "'",
                    (rs, rowNum) -> new Hello(
                            rs.getString("name"),
                            rs.getInt("count")
                    ));  //RowMapper을 이용하는데 람다식으로 바꿈
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if (hello == null) {
            jdbcTemplate.update("insert into hello values(?, ?)", name, 1);
        } else {
            jdbcTemplate.update(
                    "update hello set count = ? where name = ?",
                    hello.getCount() + 1,
                    name);
        }

    }
}

package examples.daoexam.dao;

import examples.daoexam.dto.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class UserDao {
    NamedParameterJdbcTemplate jdbc;
    SimpleJdbcInsert insertAction;
//    private Long id;
//    private String name;
//    private String email;
//    private String password;
//    private Date regdate;

    public UserDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("user").usingGeneratedKeyColumns("id");
    }

    public Long addUser(User user){
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
        return insertAction.executeAndReturnKey(source).longValue();
    }

    public User getUser(Long id){
        try {
            String sql = "select id, name, email, password, regdate from USER where id = :id";
            Map<String, Long> map = Collections.singletonMap("id", id);
            BeanPropertyRowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
            return jdbc.queryForObject(sql, map, rowMapper);
        }catch (Exception ex){
            return null;
        }
    }

    public int deleteUser(Long id){
        String sql = "delete from user where id = :id";
        Map<String, Long> map = Collections.singletonMap("id", id);
        return jdbc.update(sql, map);
    }

    public int updateUser(User user){
        String sql = "update user set name = :name, email = :email, password = :password where id = :id";
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
        return jdbc.update(sql, source);
    }
}

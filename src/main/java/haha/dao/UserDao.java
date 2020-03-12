package haha.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate template;

    public Integer getName(int id) {
        Integer succCount = template.update("update table1 set name = 'xxx' where id=" + id);
//        int i = 1 / 0;
        return succCount;
    }
}

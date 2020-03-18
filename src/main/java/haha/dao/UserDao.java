package haha.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate template;

    public Integer updateName(int id) {
        Integer succCount = template.update("update table1 set name = 'maryO' where id=" + id);
//        int i = 1 / 0;
        return succCount;
    }
}

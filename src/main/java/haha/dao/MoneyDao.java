package haha.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyDao {
    @Autowired
    private JdbcTemplate template;

    public Integer updateMoney(int money) {
        Integer succCount = template.update("update table2 set money = " + money + " where id = 1");
//        int i = 1 / 0;
        return succCount;
    }
}

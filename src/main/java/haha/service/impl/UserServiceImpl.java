package haha.service.impl;

import haha.dao.UserDao;
import haha.service.UserService;
import haha.util.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Autowired
    private TransactionUtils transactionUtils;

    @Override
    public Integer updateName1(int id) {
        return dao.getName(id);
    }

    @Override
    public int updateName2(int id) {
        TransactionStatus status = transactionUtils.begin();
        try {
            int count = dao.getName(id);
            transactionUtils.commit(status);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            // 不釋放會佔記憶體，到一定的量就會報錯
            transactionUtils.rollback(status);
        }
        return 0;
    }
}

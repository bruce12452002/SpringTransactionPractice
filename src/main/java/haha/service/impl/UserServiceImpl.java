package haha.service.impl;

import haha.dao.UserDao;
import haha.service.MoneyService;
import haha.service.UserService;
import haha.util.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Autowired
    private TransactionUtils transactionUtils;

    @Autowired
    private MoneyService moneyService;

    @Override
    public Integer updateName1(int id) {
        return dao.updateName(id);
    }

    @Override
    public int updateName2(int id) {
        TransactionStatus status = transactionUtils.begin();
        try {
            int count = dao.updateName(id);
            transactionUtils.commit(status);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            // 不釋放會佔記憶體，到一定的量就會報錯
            transactionUtils.rollback(status);
        }
        return 0;
    }

    @Override
    @Transactional("transactionManager")
    public int updateName3(int id) {
        return dao.updateName(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateName4(int id, int money) {
        dao.updateName(id);
        return moneyService.updateMoney(money);
    }
}

package haha.service.impl;

import haha.dao.MoneyDao;
import haha.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * REQUIRED：支持當前事務，不存在就創建一個新的，這是預設選項
 * <p>
 * SUPPORTS：支持當前事務，不存在就以非事務執行
 * <p>
 * MANDATORY：支持當前事務，不存在就報錯
 * <p>
 * NESTED：支持當前事務，存在事務就嵌套(有錯全部回滾，沒有錯互不影響)；不存在就創建一個新的
 * <p>
 * <p>
 * <p>
 * NOT_SUPPORTED：不使用事務，如果本來有事務就終止原來的事務
 * <p>
 * NEVER：不使用事務，如果本來有事務就報錯
 * <p>
 * <p>
 * <p>
 * REQUIRES_NEW：創建新的事務，如果本來有事務就終止原來的事務
 */
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private MoneyDao moneyDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public int updateMoney(int money) {
        return moneyDao.updateMoney(money);
    }
}

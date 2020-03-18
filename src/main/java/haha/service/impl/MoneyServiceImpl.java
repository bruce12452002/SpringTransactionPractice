package haha.service.impl;

import haha.dao.MoneyDao;
import haha.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
 *    假設A和B都是REQUIRES_NEW，A呼叫B
 *    A第一行的修改資料庫的資料沒問題，但第二行出錯, 因為有終止事務，所以第一行的資料修改成功
 *       但如果第一行出錯，第二行的修改資料沒問題，雖然有終止事務，但因為第一行就拋出例外了，所以不能修改成功
 *    B 只要A或B有例外都不會成功
 */
@Service
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private MoneyDao moneyDao;

    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateMoney(int money) {
        return moneyDao.updateMoney(money);
    }
}

package haha;

import haha.util.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

@Component
public class TransactionAOP {
    @Autowired
    private TransactionUtils tx;

    private TransactionStatus status;

    public void doSomething(ProceedingJoinPoint pjp) throws Throwable {
        status = tx.begin();
        pjp.proceed();
        tx.commit(status);
    }

    public void catchException() {
        tx.rollback(status);
    }

    /* 如果加了 try...catch 也是要處理，但一般都不用 try...catch
    public void doSomething(ProceedingJoinPoint pjp) {
        TransactionStatus status = tx.begin();
        try {
            // proceed 如果有返回值，一定是 null
            // 但如果返回值是基本型態，因為沒有 null，所以會報 Null return value from advice does not match primitive return type
            pjp.proceed();
            System.out.println("沒報錯");
            tx.commit(status);
        } catch (Throwable throwable) {
            System.out.println("有報錯");
            throwable.printStackTrace();
            tx.rollback(status);
        }
    }
    */
}

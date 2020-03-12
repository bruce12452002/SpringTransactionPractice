package haha.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class TransactionUtils {
    @Autowired
    private DataSourceTransactionManager manager;

    public TransactionStatus begin() {
        var definition = new DefaultTransactionDefinition();
        return manager.getTransaction(definition);
    }

    public void commit(TransactionStatus status) {
        manager.commit(status);
    }

    public void rollback(TransactionStatus status) {
        manager.rollback(status);
    }

}

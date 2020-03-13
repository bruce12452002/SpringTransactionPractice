package haha.service;

import haha.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoInterface {
    @Autowired
    private UserDao dao;

    @Transactional
    public int updateName(int id) {
        return dao.updateName(id);
    }
}

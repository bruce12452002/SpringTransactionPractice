package haha.service;

import haha.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoInterface {
    @Autowired
    private UserDao dao;

    public int updateName(int id) {
        return dao.getName(id);
    }
}

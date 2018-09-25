package cn.liuxingwei.spring.boot.service;

import cn.liuxingwei.spring.boot.orm.domain.UserDao;
import cn.liuxingwei.spring.boot.orm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean add(UserDao userDao) {
        return userMapper.addUser(userDao) == 1;
    }
}

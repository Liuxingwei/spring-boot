package cn.liuxingwei.spring.boot.orm.mapper;

import cn.liuxingwei.spring.boot.orm.domain.UserDao;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    UserDao getUser(Long userId);
    Integer addUser(UserDao userDao);
}

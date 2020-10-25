package dima.service;

import dima.controller.dto.UserDto;
import dima.dao.UserDao;
import dima.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegServiceImpl implements RegistrationService {
    private static final Logger logger = LogManager.getLogger(RegServiceImpl.class.getName());
    private UserDao userDao;

    public RegServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail());
        userDao.save(user);
        userDto.setId(user.getId());
        return userDto;
    }
}

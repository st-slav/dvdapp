package com.stslav.appdvd.service;

import com.stslav.appdvd.dao.UserDAO;
import com.stslav.appdvd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDAO userDAO;
    
    @Transactional(readOnly = true)
    public User getUserByLogin(String login){
        return userDAO.getUserByLogin(login);
    }
    
}

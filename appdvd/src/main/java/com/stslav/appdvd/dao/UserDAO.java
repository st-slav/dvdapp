package com.stslav.appdvd.dao;

import com.stslav.appdvd.entity.User;

public interface UserDAO {

    public User getUserByLogin(String login);
    
}

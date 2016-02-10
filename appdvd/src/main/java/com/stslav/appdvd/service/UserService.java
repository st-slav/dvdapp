package com.stslav.appdvd.service;

import com.stslav.appdvd.entity.User;

public interface UserService {
    
    public User getUserByLogin(String login);
    
}

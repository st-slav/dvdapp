package com.stslav.appdvd.service;

import com.stslav.appdvd.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("diskDetails")
@Transactional(readOnly = true)
public class UserDetailsImpl implements UserDetailsService{
    
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        com.stslav.appdvd.entity.User user = userDAO.getUserByLogin(login);
        return new User(user.getUserLogin(),
                        user.getUserPass(),
                        true, true, true, true, authList);
    }
}

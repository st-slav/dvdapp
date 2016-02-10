package com.stslav.appdvd.dao;

import com.stslav.appdvd.entity.User;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
    
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }  
    
    public User getUserByLogin(String login){
        return (User) sessionFactory.getCurrentSession().getNamedQuery("User.findUserByLogin")
                .setParameter("login", login).uniqueResult();
    }
    
}

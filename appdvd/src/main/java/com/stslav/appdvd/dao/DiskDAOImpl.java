package com.stslav.appdvd.dao;

import com.stslav.appdvd.entity.Disk;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("diskDAO")
public class DiskDAOImpl implements DiskDAO{
    
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Disk> findAll(){
        return sessionFactory.getCurrentSession().getNamedQuery("Disk.findAll").list();
    }
    
    public List<Disk> getFreeDiskList(){
        return sessionFactory.getCurrentSession().getNamedQuery("Disk.findFreeDisk").list();
    }
    
    public List<Disk> getTakenDiskListByLogin(String login){
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Disk.findTaken").setParameter("login", login).list();
    }
    
    public List<Disk> getGivenDiskListByLogin(String login){
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Disk.findGiven").setParameter("login", login).list();
    }
    
    public void addOrUpdateDisk(Disk disk){
        sessionFactory.getCurrentSession().saveOrUpdate(disk);
    }
    
    public Disk getDiskById(Long diskId){
        return (Disk) sessionFactory.getCurrentSession()
                .getNamedQuery("Disk.findById").setParameter("id", diskId).uniqueResult();
    }
}

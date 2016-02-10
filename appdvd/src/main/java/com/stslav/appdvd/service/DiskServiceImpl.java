package com.stslav.appdvd.service;

import com.stslav.appdvd.dao.DiskDAO;
import com.stslav.appdvd.entity.Disk;
import com.stslav.appdvd.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("diskService")
@Transactional
public class DiskServiceImpl implements DiskService{
    
    @Autowired
    private DiskDAO diskDAO;
    
    @Autowired
    private UserService userService;
    
    @Transactional(readOnly = true)
    public List<Disk> findAll(){
        return diskDAO.findAll();
    } 
    
    @Transactional(readOnly = true)
    public List<Disk> getFreeDiskList(){
        return diskDAO.getFreeDiskList();
    }
    
    @Transactional(readOnly = true)
    public List<Disk> getGivenDiskList(String login){
        return diskDAO.getGivenDiskListByLogin(login);
    }
    
    @Transactional(readOnly = true)
    public List<Disk> getTakenDiskList(String login){
        return diskDAO.getTakenDiskListByLogin(login);
    }
    
    public void addDisk(Disk disk, String login){
        User user = userService.getUserByLogin(login);
        disk.setUser(user);
        diskDAO.addOrUpdateDisk(disk);
    }
    
    public String takeDisk(Disk disk, String login){
        Disk dsk = diskDAO.getDiskById(disk.getDiskId());
        System.out.println(dsk.getDiskId());
        if(dsk.getUser().getUserLogin().equals(login)){
            return "Это ваш диск";
        } else if (dsk.getUserTaken() != null){
            return "Этот диск уже кто-то взял";
        } else {
            dsk.setUserTaken(userService.getUserByLogin(login));
            diskDAO.addOrUpdateDisk(dsk);
            return "Диск успешно взят";
        }
    }
    
    public void returnDisk(Disk disk){
        Disk dsk = diskDAO.getDiskById(disk.getDiskId());
        dsk.setUserTaken(null);
        diskDAO.addOrUpdateDisk(dsk);
    }
}

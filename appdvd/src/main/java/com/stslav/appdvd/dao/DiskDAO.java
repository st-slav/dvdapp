package com.stslav.appdvd.dao;

import com.stslav.appdvd.entity.Disk;
import java.util.List;

public interface DiskDAO {
    
    public List<Disk> findAll();
    
    public List<Disk> getFreeDiskList();
    
    public List<Disk> getTakenDiskListByLogin(String login);
    
    public List<Disk> getGivenDiskListByLogin(String login);

    public void addOrUpdateDisk(Disk disk);
    
    public Disk getDiskById(Long diskId);
}

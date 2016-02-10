package com.stslav.appdvd.service;

import com.stslav.appdvd.entity.Disk;
import java.util.List;

public interface DiskService {
    
    public List<Disk> findAll();
    
    public List<Disk> getFreeDiskList();
    
    public List<Disk> getGivenDiskList(String login);
    
    public List<Disk> getTakenDiskList(String login);

    public void addDisk(Disk disk, String login);
    
    public String takeDisk(Disk disk, String login);
    
    public void returnDisk(Disk disk);
}

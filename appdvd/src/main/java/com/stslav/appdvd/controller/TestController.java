package com.stslav.appdvd.controller;

import com.stslav.appdvd.entity.Disk;
import com.stslav.appdvd.service.DiskService;
import com.stslav.appdvd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dvd")
public class TestController {
    
    @Autowired
    private DiskService diskService;
    
    @Autowired
    private UserService userService;
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/given", method = RequestMethod.GET)
    public String getGivenPage (Model uiModel){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        uiModel.addAttribute("disks", diskService.getGivenDiskList(login));
        return "/given";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = {"/catalog"}, method = RequestMethod.GET)
    public String getCatalogPage (Model uiModel){
        uiModel.addAttribute("disk", new Disk());
        uiModel.addAttribute("disks", diskService.getFreeDiskList());
        return "/catalog";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String getCreatePage(Model uiModel){
        uiModel.addAttribute("disk", new Disk());
        return "/create";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/taken", method = RequestMethod.GET)
    public String getTakenPage(Model uiModel){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        uiModel.addAttribute("disk", new Disk());
        uiModel.addAttribute("disks", diskService.getTakenDiskList(login));
        return "/taken";        
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = {"/catalog"}, method = RequestMethod.POST)
    public String takeDisk(@ModelAttribute("disk") Disk disk, Model uiModel){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        uiModel.addAttribute("message", diskService.takeDisk(disk, login));
        uiModel.addAttribute("disks", diskService.getFreeDiskList());
        return "/catalog";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/taken", method = RequestMethod.POST)
    public String returnDisk(@ModelAttribute("disk") Disk disk, Model uiModel){
        diskService.returnDisk(disk);
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        uiModel.addAttribute("disks", diskService.getTakenDiskList(login));
        uiModel.addAttribute("message", "Вы успешно отдали диск!");
        return "/taken";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addDisk(@ModelAttribute("disk") Disk disk, Model uiModel){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        diskService.addDisk(disk, login);
        uiModel.addAttribute("message", "Диск успешно добавлен");
        return "/create";
    }

    @RequestMapping(value = "/auth")
    public String getAuth(){
        return "/auth";
    }
    
    @RequestMapping(value = "/auth/err")
    public String getAuthErr(Model uiModel){
        uiModel.addAttribute("message", "Неверные логин/пароль");
        return "/auth";
    }
}


package com.stslav.appdvd.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="User")
@NamedQueries({
    @NamedQuery(name = "User.findUserByLogin", query = "from User where userLogin = :login")
})
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private Long userId;
    
    @Column(name = "User_login")
    private String userLogin;
    
    @Column(name = "User_pass")
    private String userPass;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Disk> diskList;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "takenitem",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "Disk_id"))
    private List<Disk> diskTaken;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<Disk> getDiskList() {
        return diskList;
    }

    public void setDiskList(List<Disk> diskList) {
        this.diskList = diskList;
    }

    public List<Disk> getDiskTeken() {
        return diskTaken;
    }

    public void setDiskTeken(List<Disk> diskTeken) {
        this.diskTaken = diskTeken;
    }
}

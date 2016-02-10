package com.stslav.appdvd.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Disk")
@NamedQueries({
    @NamedQuery(name = "Disk.findAll", query = "from Disk d order by d.diskTitle"),
    @NamedQuery(name = "Disk.findFreeDisk", query = "from Disk d where d.userTaken = null order by d.diskTitle"),
    @NamedQuery(name = "Disk.findTaken", query = "from Disk d where d.userTaken.userLogin = :login"),
    @NamedQuery(name = "Disk.findGiven", 
            query = "from Disk d inner join fetch d.userTaken ut where d.user.userLogin = :login and ut != null order by d.diskTitle"),
    @NamedQuery(name = "Disk.findById", query = "from Disk d where d.diskId = :id")  
})
public class Disk implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Disk_id")
    private Long diskId;
    
    @Column(name = "Disk_title")
    private String diskTitle;
    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private User user;
    
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "takenitem",
            joinColumns = @JoinColumn(name = "Disk_id"),
            inverseJoinColumns = @JoinColumn(name = "User_id"))
    private User userTaken;

    public Long getDiskId() {
        return diskId;
    }

    public void setDiskId(Long diskId) {
        this.diskId = diskId;
    }

    public String getDiskTitle() {
        return diskTitle;
    }

    public void setDiskTitle(String diskTitle) {
        this.diskTitle = diskTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserTaken() {
        return userTaken;
    }

    public void setUserTaken(User userTaken) {
        this.userTaken = userTaken;
    }
    
}

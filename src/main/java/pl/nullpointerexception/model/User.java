package pl.nullpointerexception.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {
    @Id
    private Long id;
    private String userName;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Privileges> privileges;


    public User(Long id, String userName, List<Privileges> privileges) {
        this.id = id;
        this.userName = userName;
        this.privileges = privileges;
    }

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public List<Privileges> getPrivileges() {
        return this.privileges;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPrivileges(List<Privileges> privileges) {
        this.privileges = privileges;
    }
}

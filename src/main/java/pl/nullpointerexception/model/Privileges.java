package pl.nullpointerexception.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Privileges {
    @Id
    private Long id;
    private String name;
    private boolean active;

    public Privileges(Long id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Privileges() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

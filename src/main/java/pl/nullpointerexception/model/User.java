package pl.nullpointerexception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String userName;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Privileges> privileges;


}

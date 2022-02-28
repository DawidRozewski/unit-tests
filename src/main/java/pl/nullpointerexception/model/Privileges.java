package pl.nullpointerexception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Privileges {
    @Id
    private Long id;
    private String name;
    private boolean active;

}

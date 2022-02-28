package pl.nullpointerexception.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Customer {
    @Id
    private Long id;
    private String name;
    private boolean active;

}

package pl.nullpointerexception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private PolicyStatus status;

    private long parentId;

    private LocalDateTime created;

    @OneToOne(cascade = CascadeType.PERSIST)
    private CustomerPolicyConfiguration configuration;

    private Long creatorId;


}

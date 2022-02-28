package pl.nullpointerexception.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    public Policy(Long id, Customer customer, PolicyStatus status, long parentId, LocalDateTime created, CustomerPolicyConfiguration configuration, Long creatorId) {
        this.id = id;
        this.customer = customer;
        this.status = status;
        this.parentId = parentId;
        this.created = created;
        this.configuration = configuration;
        this.creatorId = creatorId;
    }

    public Policy() {
    }

    public Long getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public PolicyStatus getStatus() {
        return this.status;
    }

    public long getParentId() {
        return this.parentId;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public CustomerPolicyConfiguration getConfiguration() {
        return this.configuration;
    }

    public Long getCreatorId() {
        return this.creatorId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setConfiguration(CustomerPolicyConfiguration configuration) {
        this.configuration = configuration;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}

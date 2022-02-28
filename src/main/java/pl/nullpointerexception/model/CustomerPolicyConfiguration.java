package pl.nullpointerexception.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CustomerPolicyConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal amountDiscount;
    private BigDecimal percentDiscount;
    @OneToOne
    private PolicyConfiguration policyConfiguration;


    public CustomerPolicyConfiguration(long id, BigDecimal amountDiscount, BigDecimal percentDiscount, PolicyConfiguration policyConfiguration) {
        this.id = id;
        this.amountDiscount = amountDiscount;
        this.percentDiscount = percentDiscount;
        this.policyConfiguration = policyConfiguration;
    }

    public CustomerPolicyConfiguration() {
    }

    public long getId() {
        return this.id;
    }

    public BigDecimal getAmountDiscount() {
        return this.amountDiscount;
    }

    public BigDecimal getPercentDiscount() {
        return this.percentDiscount;
    }

    public PolicyConfiguration getPolicyConfiguration() {
        return this.policyConfiguration;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmountDiscount(BigDecimal amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    public void setPercentDiscount(BigDecimal percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public void setPolicyConfiguration(PolicyConfiguration policyConfiguration) {
        this.policyConfiguration = policyConfiguration;
    }
}

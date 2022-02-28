package pl.nullpointerexception.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class PolicyConfiguration {

    @Id
    private long id;
    private BigDecimal amountDiscount;
    private BigDecimal percentDiscount;


    public PolicyConfiguration(long id, BigDecimal amountDiscount, BigDecimal percentDiscount) {
        this.id = id;
        this.amountDiscount = amountDiscount;
        this.percentDiscount = percentDiscount;
    }

    public PolicyConfiguration() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setAmountDiscount(BigDecimal amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    public void setPercentDiscount(BigDecimal percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
}

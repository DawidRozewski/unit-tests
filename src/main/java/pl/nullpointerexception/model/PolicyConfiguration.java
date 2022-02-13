package pl.nullpointerexception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyConfiguration {

    @Id
    private long id;
    private BigDecimal amountDiscount;
    private BigDecimal percentDiscount;


}

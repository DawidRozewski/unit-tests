package pl.nullpointerexception.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class PolicyConfiguration {

    @Id
    private long id;
    private BigDecimal amountDiscount;
    private BigDecimal percentDiscount;

}

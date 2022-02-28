package pl.nullpointerexception.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class CustomerPolicyConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal amountDiscount;
    private BigDecimal percentDiscount;
    @OneToOne
    private PolicyConfiguration policyConfiguration;

}

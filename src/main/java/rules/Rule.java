package rules;

import java.math.BigDecimal;

import entity.Family;

public interface Rule {
    BigDecimal sumPoints ( Family family );
}

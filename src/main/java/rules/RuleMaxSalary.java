package rules;

import java.math.BigDecimal;

import entity.Family;

public class RuleMaxSalary implements Rule {

    @Override
    public BigDecimal sumPoints ( Family family ) {
        BigDecimal salarySum = BigDecimal.valueOf( family.getFamilyMembers()
            .stream()
            .mapToDouble( familyMember -> familyMember.getSalary().doubleValue() )
            .sum() );
        return ( salarySum.compareTo( new BigDecimal( "0" ) ) > 0
            && salarySum.compareTo( new BigDecimal( "901" ) ) < 0 )
            ? new BigDecimal( "3" ) : new BigDecimal( "0" );

    }
}

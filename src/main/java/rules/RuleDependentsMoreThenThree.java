package rules;

import java.math.BigDecimal;

import entity.Family;
import enums.MemberType;

public class RuleDependentsMoreThenThree implements Rule {

    @Override
    public BigDecimal sumPoints ( Family family ) {
        return family.getFamilyMembers()
            .stream()
            .filter( familyMember -> familyMember.getMemberType().equals( MemberType.DEPENDENT ) )
            .filter( familyMember -> familyMember.getAge() < 18 )
            .count() >= 3 ? new BigDecimal( 3 ) : new BigDecimal( "0" );
    }
}

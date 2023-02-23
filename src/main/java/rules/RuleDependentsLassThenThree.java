package rules;

import java.math.BigDecimal;

import entity.Family;
import enums.MemberType;

public class RuleDependentsLassThenThree implements Rule {

    @Override
    public BigDecimal sumPoints ( Family family ) {
        long availableDependents = family.getFamilyMembers()
            .stream()
            .filter( familyMember -> familyMember.getMemberType().equals( MemberType.DEPENDENT ) )
            .filter( familyMember -> familyMember.getAge() < 18 )
            .count();
        return availableDependents <= 2 && availableDependents > 0 ? new BigDecimal( 2 ) : new BigDecimal( "0" );
    }
}

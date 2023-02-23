import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;

import entity.Family;
import entity.FamilyMember;
import enums.MemberType;
import enums.RuleType;
import rules.Rule;
import rules.RuleFactory;

public class RuleDependentsLassThenThreeTestes {

    @Test
    public void testRuleDependentsLassThenThree () {

        FamilyMember holder = new FamilyMember(
            UUID.randomUUID(), "Maria da silva", 56, new BigDecimal( "1250" ), MemberType.HOLDER
        );

        FamilyMember memberSon = new FamilyMember(
            UUID.randomUUID(), "John", 10, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        Family family = new Family( UUID.randomUUID(), Arrays.asList( holder, memberSon ) );

        Rule rule = RuleFactory.create( RuleType.DEPENDENTS_LASS_THEN_3 );
        BigDecimal sumPoints = rule.sumPoints( family );
        assertEquals( sumPoints, new BigDecimal( "2" ) );
    }
}

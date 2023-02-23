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

public class RuleDependentsMoreThenThreeTestes {

    @Test
    public void testRuleDependentsMoreThenThree () {

        FamilyMember holder = new FamilyMember(
            UUID.randomUUID(), "Maria da silva", 56, new BigDecimal( "1250" ), MemberType.HOLDER
        );

        FamilyMember memberSon = new FamilyMember(
            UUID.randomUUID(), "John", 10, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        FamilyMember memberDaughter = new FamilyMember(
            UUID.randomUUID(), "Alicce", 8, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        FamilyMember memberDaughter2 = new FamilyMember(
            UUID.randomUUID(), "Alana", 16, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        Family family = new Family( UUID.randomUUID(), Arrays.asList( holder, memberSon, memberDaughter, memberDaughter2 ) );

        Rule rule = RuleFactory.create( RuleType.DEPENDENTS_MORE_THEN_3 );
        BigDecimal sumPoints = rule.sumPoints( family );
        assertEquals( sumPoints, new BigDecimal( "3" ) );
    }
}

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;

import entity.Family;
import entity.FamilyMember;
import rules.Rule;
import rules.RuleFactory;
import enums.RuleType;
import enums.MemberType;

public class RuleMaxSalaryTests {

    @Test
    public void testRuleMaxSalary () {

        FamilyMember holder = new FamilyMember(
            UUID.randomUUID(), "Maria da silva", 56, new BigDecimal( "900" ), MemberType.HOLDER
        );

        FamilyMember memberSon = new FamilyMember(
            UUID.randomUUID(), "John", 10, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        FamilyMember memberDaughter = new FamilyMember(
            UUID.randomUUID(), "Alicce", 8, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        Family family = new Family( UUID.randomUUID(), Arrays.asList( holder, memberSon, memberDaughter ) );

        Rule rule = RuleFactory.create( RuleType.MAX_SALARY );
        BigDecimal sumPoints = rule.sumPoints( family );
        assertEquals( sumPoints, new BigDecimal( "3" ) );
    }
}

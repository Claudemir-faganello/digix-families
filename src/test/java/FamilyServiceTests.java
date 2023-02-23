import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import entity.Family;
import entity.FamilyMember;
import enums.MemberType;
import service.FamilyService;
import service.FamilyServiceImpl;

public class FamilyServiceTests {

    private FamilyService familyService = new FamilyServiceImpl();

    @Test
    public void testListFamiliesOrdered () {
        List< Family > orderedFamilyList = familyService.listFamiliesOrdered(
            Arrays.asList( createFamily1(), createFamily2(), createFamily3() )
        );
        assertTrue( orderedFamilyList.get( 0 ).getPoints().compareTo( orderedFamilyList.get( 1 ).getPoints() ) > 0 );
    }

    private Family createFamily1 () {
        FamilyMember holder = new FamilyMember(
            UUID.randomUUID(), "Maria da silva", 56, new BigDecimal( "1150" ), MemberType.HOLDER
        );

        FamilyMember memberSon = new FamilyMember(
            UUID.randomUUID(), "John", 10, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        FamilyMember memberDaughter = new FamilyMember(
            UUID.randomUUID(), "Alicce", 8, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        return new Family( UUID.randomUUID(), Arrays.asList( holder, memberSon, memberDaughter ) );
    }

    private Family createFamily2 () {
        FamilyMember holder = new FamilyMember(
            UUID.randomUUID(), "Fernanda da fonseca", 56, new BigDecimal( "1250" ), MemberType.HOLDER
        );

        FamilyMember memberSon = new FamilyMember(
            UUID.randomUUID(), "Vitor", 16, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        FamilyMember memberDaughter = new FamilyMember(
            UUID.randomUUID(), "Lucas", 1, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        FamilyMember memberDaughter2 = new FamilyMember(
            UUID.randomUUID(), "Joaquim", 3, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        FamilyMember memberDaughter3 = new FamilyMember(
            UUID.randomUUID(), "Mariana", 3, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        return new Family( UUID.randomUUID(), Arrays.asList( holder, memberSon, memberDaughter, memberDaughter2, memberDaughter3 ) );
    }

    private Family createFamily3 () {
        FamilyMember holder = new FamilyMember(
            UUID.randomUUID(), "Caio da luz", 56, new BigDecimal( "800" ), MemberType.HOLDER
        );

        FamilyMember memberSon = new FamilyMember(
            UUID.randomUUID(), "Azlok", 12, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        FamilyMember memberDaughter = new FamilyMember(
            UUID.randomUUID(), "Hagnar", 6, new BigDecimal( "0" ), MemberType.DEPENDENT
        );

        return new Family( UUID.randomUUID(), Arrays.asList( holder, memberSon, memberDaughter ) );
    }
}

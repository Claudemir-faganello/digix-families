package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import entity.Family;
import enums.RuleType;
import rules.Rule;
import rules.RuleFactory;

public class FamilyServiceImpl implements FamilyService {
    @Override
    public List< Family > listFamiliesOrdered ( List< Family > families ) {
        families.forEach( this::setFamilyPoints );

        return families.stream().sorted( ( o1, o2 ) -> o2.getPoints().compareTo( o1.getPoints() ) ).
            collect( Collectors.toList() );
    }

    private void setFamilyPoints ( Family family ) {
        Arrays.stream( RuleType.values() ).forEach( ruleType -> {
            Rule rule = RuleFactory.create( ruleType );
            family.addPoint( rule.sumPoints( family ) );
        } );
    }

}

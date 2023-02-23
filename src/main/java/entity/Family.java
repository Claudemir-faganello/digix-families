package entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( onlyExplicitlyIncluded = true )
public class Family {

    @EqualsAndHashCode.Include
    private UUID id;
    private List< FamilyMember > familyMembers;

    private BigDecimal points;

    public Family ( UUID id, List< FamilyMember > familyMembers ) {
        this.id = id;
        this.familyMembers = familyMembers;
        this.points = new BigDecimal( "0" );
    }

    public void addPoint ( BigDecimal points ) {
        this.points = this.points.add( points );
    }
}

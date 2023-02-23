package entity;

import java.math.BigDecimal;
import java.util.UUID;

import enums.MemberType;
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
public class FamilyMember {

    @EqualsAndHashCode.Include
    private UUID id;
    private String name;
    private Integer age;
    private BigDecimal salary;

    private MemberType memberType;
}

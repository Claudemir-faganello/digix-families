package rules;

import enums.RuleType;

public abstract class RuleFactory {

    public static Rule create ( RuleType ruleType ) {
        switch ( ruleType ) {
            case MAX_SALARY: {
                return new RuleMaxSalary();
            }
            case SALARY_BETWEEN: {
                return new RuleSalaryBetween();
            }
            case DEPENDENTS_MORE_THEN_3: {
                return new RuleDependentsMoreThenThree();
            }
            case DEPENDENTS_LASS_THEN_3: {
                return new RuleDependentsLassThenThree();
            }
            default:
                throw new IllegalArgumentException( "Rule not found!" );

        }
    }
}

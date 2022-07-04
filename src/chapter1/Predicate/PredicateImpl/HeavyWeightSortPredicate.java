package chapter1.Predicate.PredicateImpl;

import chapter1.Predicate.Predicate;
import chapter1.Vo.Fruit;

public class HeavyWeightSortPredicate implements Predicate {
    @Override
    public boolean isTest(Object o) {
        Fruit fruit = (Fruit) o;


        return false;
    }
}

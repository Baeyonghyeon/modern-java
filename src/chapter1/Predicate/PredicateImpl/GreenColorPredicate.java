package chapter1.Predicate.PredicateImpl;

import chapter1.Color.Color;
import chapter1.Predicate.Predicate;
import chapter1.Vo.Fruit;

public class GreenColorPredicate implements Predicate {

    @Override
    public boolean isTest(Object o) {
        Fruit fruit = (Fruit) o;

        return fruit.getColor() == Color.GREEN;
    }
}

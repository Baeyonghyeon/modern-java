package chapter1;

import chapter1.Predicate.Predicate;

import java.util.ArrayList;
import java.util.List;

public class FilterFruit {

    public <T> List<T> filterApples(List<T> inventory, Predicate<T> predicate) {

        List<T> result = new ArrayList<>();

        for (T object : inventory) {
            if (predicate.isTest(object)) {
                result.add(object);
            }
        }
        return result;
    }



}


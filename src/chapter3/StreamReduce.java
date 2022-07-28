package chapter3;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamReduce {

    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.MEAT),
            new Dish("rice", true, 350, Dish.Type.MEAT),
            new Dish("season fruit", true, 120, Dish.Type.MEAT),
            new Dish("pizza", true, 550, Dish.Type.MEAT),
            new Dish("prawns", false, 300, Dish.Type.MEAT),
            new Dish("salmon", false, 450, Dish.Type.MEAT)
    );

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        /**
         *  두 요소를 조합해서 만드는 reduce 메서드
         *  BinaryOperator<T> 사용
         */
        int sum = numbers.stream()
                .reduce(0, Integer::sum); // reduce(0, (a, b) -> a + b) 메소드 참조 사용
        System.out.println("sum : " + sum);

        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("product : " + product);

        /**
         * 초기값이 존재하지 않는 reduce 도 있다. 기본적으로 0 으로 초기화 되는 것을 확인 할 수 있다.
         */
        Optional<Integer> optionalSum = numbers.stream()
                .reduce(Integer::sum);
        System.out.println("optionalSum : " + optionalSum.get());

        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);
        System.out.println("max : " + max.get());

        Optional<Integer> min = numbers.stream()
                .reduce(Integer::min);
        System.out.println("min : " + min.get());


        /**
         * 음식의 개수를 map, reduce 를 사용하여 구하시오.
         */
        int count1 = menu.stream()
                .map(dish -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println("count1 : " + count1);

        List<Integer> changeList = menu.stream()
                .map(dish -> 1)
                .collect(Collectors.toList());
        System.out.println("changeList : " + changeList);

        //count() 사용
        long count2 = menu.stream()
                .count();
        System.out.println("count2 : " + count2);
    }
}
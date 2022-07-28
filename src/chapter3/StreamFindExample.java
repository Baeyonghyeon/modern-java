package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindExample {

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
        /**
         * findAny - 현재 스트림에서 임의의 요소를 반환한다.
         */
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny() // Optional<Dish> 반환
                .ifPresent(dish -> System.out.println(dish.getName()));

        /**
         * findFirst - 일부 스트림에는 논리적인 아이템 순서가 정해져 있을 수 있다.
         *
         * why : findFirst 와 findAny는 언제 사용할까?
         * 병렬성 때문에
         */
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .ifPresent(number -> System.out.println(number));
    }
}

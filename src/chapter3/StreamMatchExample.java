package chapter3;

import java.util.Arrays;
import java.util.List;

public class StreamMatchExample {

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
         * 특정 속성이 데이터 집합에 있는지 여부를 검색. boolean을 반환하므로 최종 연산이다.
         * anyMatch 메서드는 한 요소와 일치하는지 확인할때 사용. (한개만 일치해도 true)
         */
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("menu에 채식요리가 포함되어 있다.");
        }

        /**
         * allMatch - 주어진 모든 요소가 일치해야 한다.
         */
        boolean isHealthy1 = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("isHealthy : " + isHealthy1);

        /**
         * noneMatch - 주어진 모든 요소가 일치하면 안된다.
         */
        boolean isHealthy2 = menu.stream()
                .noneMatch(dish -> dish.getCalories() > 1000);
        System.out.println("isNoneHealthy : " + isHealthy2);
    }
}

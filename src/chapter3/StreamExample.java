package chapter3;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

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
        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("threeHighCaloricDishNames : " + threeHighCaloricDishNames);

        List<String> filterMenu1 = menu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("filterMenu1 : " + filterMenu1);

        /**
         * java 9 추가 기능
         * java 8에 filter라는 Predicate가 있는데 왜 만들었을까??
         * -> 이미 정렬되어 있다면 false가 등장하는 위치부터 반복을 중단할 수 있기 때문에 크기가 큰 스트림의 경우 많은 시간을 절약할 수 있다.
         * takeWhile를 적용하면 무한 스트림을 포함한 모든 스트림에 Predicate를 적용해 슬라이스 가능.
         */
        List<String> filterMenu2 = menu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("filterMenu2 : " + filterMenu2);

        /**
         * dropWhile takeWhile과 다르게 나머지 요소를 선택하고 싶을때 사용한다.
         */
        List<String> filterMenu3 = menu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("filterMenu3 : " + filterMenu3);

        /**
         * skip - 처음 n개 요소를 제외한 스트림을 반환한다.
         */
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("dishes : " + dishes);

        /**
         * 매핑 map은 값을 고친다는 것 보단 새로운 버전을 만든다는 개념이다.
         */
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLength = words.stream()
                .map(String::length) // 메소드 참조 매핑
                .collect(Collectors.toList());
        System.out.println("wordLength : " + wordLength);

        /**
         * 만약 요리(객체)의 이름 길이를 뽑고 싶다면??
         * 매핑을 먼저 name을 하면 된다.
         */
        List<Integer> dishLength = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("dishLength : " + dishLength);

        /**
         * 숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbersSq = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("numbersSq : " + numbersSq);

        /**
         * 두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환하시오.
         */
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs1 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        System.out.println(pairs1);

        /**
         *  이전 예제에서 합이 3으로 나누어 떨어지는 쌍만 반환하시오.
         */
        List<int[]> pairs2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i+j) % 3 == 0)
                        .map(j -> new int[]{i,j}))
                .collect(Collectors.toList());
        System.out.println(pairs2);
    }

}

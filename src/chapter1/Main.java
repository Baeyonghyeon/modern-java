package chapter1;

import chapter1.Color.Color;
import chapter1.Predicate.Predicate;
import chapter1.Predicate.PredicateImpl.GreenColorPredicate;
import chapter1.Predicate.PredicateImpl.HeavyWeightPredicate;
import chapter1.Vo.Apple;
import chapter1.Vo.Banana;
import chapter1.Vo.Fruit;
import chapter1.Vo.Orange;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final FilterFruit filterApple = new FilterFruit();

    public static void main(String[] args) {
        List<Fruit> AppleBasket = Arrays.asList(new Apple(130, Color.GREEN)
                , new Apple(170, Color.RED)
                , new Apple(120, Color.RED)
                , new Apple(150, Color.RED)
                , new Apple(110, Color.RED));

        List<Fruit> OrangeBasket = Arrays.asList(new Orange(130, Color.GREEN)
                , new Orange(170, Color.RED));

        List<Fruit> BananaBasket = Arrays.asList(new Banana(130, Color.GREEN)
                , new Banana(170, Color.RED));

        Predicate heavyWeightPredicate = new HeavyWeightPredicate();
        Predicate greenColorPredicate = new GreenColorPredicate();

        //클래스를 활용한 동작 파라미터화
        System.out.println("Apple Weight : " + filterApple.filterApples(AppleBasket, heavyWeightPredicate));
        System.out.println("Apple Color : " + filterApple.filterApples(AppleBasket, greenColorPredicate));

        System.out.println("Orange Weight : " + filterApple.filterApples(OrangeBasket, heavyWeightPredicate));
        System.out.println("Oragne Color : " + filterApple.filterApples(OrangeBasket, greenColorPredicate));

        System.out.println("Banana Weight : " + filterApple.filterApples(BananaBasket, heavyWeightPredicate));
        System.out.println("Banana Color : " + filterApple.filterApples(BananaBasket, greenColorPredicate));


        //람다를 활용한 동작 파라미터화
        System.out.println("Filter Weight : " + filterApple.filterApples(AppleBasket, (Fruit fruit) -> fruit.getWeight() > 150));
        System.out.println("Filter Color : " + filterApple.filterApples(AppleBasket, (Fruit fruit) -> Color.RED == fruit.getColor()));

        //무게순으로 정렬해보자.
        List<Fruit> sortList1 = AppleBasket.stream()
                .sorted((a1, a2) -> a1.getWeight() - a2.getWeight())
                .collect(Collectors.toList());

        List<Fruit> sortList2 = AppleBasket.stream()
                .sorted(Comparator.comparingInt(Fruit::getWeight))
                .collect(Collectors.toList());

        //람다 사용 정렬
        System.out.println("스트림 사용1 무게 순으로 정렬해 보았다. : " + sortList1);
        //메소드 참조 정렬
        System.out.println("스트림 사용2 무게 순으로 정렬해 보았다. : " + sortList2);
    }
}

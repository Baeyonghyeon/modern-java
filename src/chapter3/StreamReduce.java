package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class StreamReduce {
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
    }
}

package chapter2.Cosumer;

import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample1 {

    public static void main(String[] args) {

        Consumer<String> consumer = s -> System.out.println(s.toUpperCase(Locale.ROOT));

        consumer.accept("hello world");
    }
}

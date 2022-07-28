package chapter3;

import java.util.stream.Stream;

public class StreamNullCheck {
    /**
     * 작업을 하다보면 null 이 될 수 있는 객체를 스트림으로 만들어야 할 수 있다. (java 9)
     */
    Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));

    /**
     * Null 객체를 포함하는 스트림값을 flatMap과 함께 사용하는 상황
     */
    Stream<String> values = Stream.of("config", "home", "user")
            .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
}

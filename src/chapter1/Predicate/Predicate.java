package chapter1.Predicate;

@FunctionalInterface
public interface Predicate<T> {
    boolean isTest(T t);
}

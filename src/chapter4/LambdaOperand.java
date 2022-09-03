package chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class LambdaOperand {
    Map<String, DoubleBinaryOperator> basket;
    public LambdaOperand() {
        basket = new HashMap<>();

        basket.put("+", (a, b) -> a + b);
        basket.put("-", (a, b) -> a - b);
        basket.put("*", (a, b) -> a * b);
        basket.put("/", (a, b) -> a / b);
    }

    public double calculate(double leftValue,  String operand, double rightValue) {
        return basket.get(operand).applyAsDouble(leftValue, rightValue);
    }
}

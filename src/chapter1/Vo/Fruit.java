package chapter1.Vo;

import chapter1.Color.Color;

public class Fruit {
    private final int weight;
    private final Color color;

    public Fruit(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}

package chapter1.Color;


public enum Color {
    GREEN("GREEN"), RED("RED"), YELLOW("YELLOW");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

package chapter5.object;

import chapter5.object.ov.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final String name;
    private final List<Food> foods = new ArrayList<>();

    public Shop(String shopName, Food food) {
        this.name = shopName;
        this.foods.add(food);
    }

    public void addFood(Food food){
        foods.add(food);
    }

    public String getShopName() {
        return name;
    }

    public List<Food> getFoods() {
        return foods;
    }
}

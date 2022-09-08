package chapter5.repository;

import chapter5.object.Shop;
import chapter5.object.ov.Food;
import chapter5.object.ov.Order;

public interface ShopRepository {

    void registerShop(Shop shop);

    void registerFood(String shopName, Food food);

    boolean isCheckShop(String shopName);

    boolean isCheckFood(Order order);

    void orderFood(Order order);
}

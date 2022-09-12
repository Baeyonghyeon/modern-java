package chapter5.repository.impl;

import chapter5.object.Shop;
import chapter5.object.ov.Food;
import chapter5.object.ov.Order;
import chapter5.repository.ShopRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopRepositoryImpl implements ShopRepository {

    List<Shop> shops = new ArrayList<>();

    @Override
    public void registerShop(Shop shop) {
        shops.add(shop);
    }

    @Override
    public void registerFood(String shopName, Food food) {
        shops.stream()
                .filter(s -> s.getShopName().equals(shopName))
                .findFirst()
                .ifPresent(shop -> shop.addFood(food));
    }

    @Override
    public boolean isCheckShop(String shopName) {
        return shops.stream()
                .map(Shop::getShopName)
                .anyMatch(s -> s.equals(shopName));
    }

    @Override
    public boolean isCheckFood(Order order) {
        Optional<Shop> shop = shops.stream()
                .filter(s -> s.getShopName().equals(order.getShopName()))
                .findFirst();

        return shop.get().getFoods().stream()
                .anyMatch(food -> food.getName().equals(order.getFoodName()));
    }

    @Override
    public void orderFood(Order order) {
        if (isCheckShop(order.getShopName()) && isCheckFood(order)) {
            System.out.println("주문 완료");
        } else {
            System.out.println("올바르지 않은 주문.");
        }
    }

}

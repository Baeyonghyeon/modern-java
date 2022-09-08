package chapter5.repository.impl;

import chapter5.object.Shop;
import chapter5.object.ov.Food;
import chapter5.object.ov.Order;
import chapter5.repository.ShopRepository;

import java.util.ArrayList;
import java.util.List;

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

    // todo: 해당 가게에 음식이 존재하는지 체크해야 한다.
    @Override
    public boolean isCheckFood(Order order) {
        return true;
    }

    // todo : 주문되게 완성 하기..
    @Override
    public void orderFood(Order order) {
        if (isCheckShop(order.getShopName()) && isCheckFood(order)){
            //주문이 되게끔,,,?
        } else {
            System.out.println("올바르지 않은 주문.");
        }
    }

}

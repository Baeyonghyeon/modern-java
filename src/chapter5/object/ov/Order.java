package chapter5.object.ov;

public class Order {

    private final String userName;
    private final String shopName;
    private final String foodName;

    public Order(String userName, String shopName, String foodName) {
        this.userName = userName;
        this.shopName = shopName;
        this.foodName = foodName;
    }

    public String getUserName() {
        return userName;
    }

    public String getShopName() {
        return shopName;
    }

    public String getFoodName() {
        return foodName;
    }
}
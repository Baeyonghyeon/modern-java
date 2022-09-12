package chapter5.object.ov;

public class Review {

    private final String Username;
    private final String shopName;
    private final String foodName;
    private final int grade;

    public Review(String username, String shopName, String foodName, int grade) {
        Username = username;
        this.shopName = shopName;
        this.foodName = foodName;
        this.grade = grade;
    }

    public String getUsername() {
        return Username;
    }

    public String getShopName() {
        return shopName;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getGrade() {
        return grade;
    }
}

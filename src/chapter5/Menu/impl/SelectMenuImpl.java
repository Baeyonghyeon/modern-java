package chapter5.Menu.impl;

import chapter5.Menu.SelectMenu;
import chapter5.object.Shop;
import chapter5.object.ov.Food;
import chapter5.object.ov.Order;
import chapter5.object.ov.Review;
import chapter5.repository.ReviewRepository;
import chapter5.repository.ShopRepository;
import chapter5.repository.impl.ReviewRepositoryImpl;
import chapter5.repository.impl.ShopRepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class SelectMenuImpl implements SelectMenu {

    ShopRepository shopRepository = new ShopRepositoryImpl();
    ReviewRepository reviewRepository = new ReviewRepositoryImpl();

    @Override
    public void selectAddShopMenu(BufferedReader br) throws IOException {
        String addList[] = new String[3];

        System.out.println("[안내] 반갑습니다. 가맹주님!");
        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        addList[0] = br.readLine();

        System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
        System.out.print(">>> ");
        addList[1] = br.readLine();

        System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
        System.out.print(">>> ");
        addList[2] = br.readLine();

        Food food = new Food(addList[1], Integer.parseInt(addList[2]));

        if (shopRepository.isCheckShop(addList[0])) {
            shopRepository.registerFood(addList[0], food);
            System.out.println("이미등록된 가게입니다. && 음식 등록완료. ");

        } else {
            Shop shop = new Shop(addList[0], food);
            shopRepository.registerShop(shop);
            System.out.println("가게 등록완료. && 음식 등록완료. ");
        }
    }

    @Override
    public void selectDashboardMenu() {
        reviewRepository.getAllReviews().stream()
                .forEach(System.out::println);
    }

    @Override
    public void selectOrderMenu(BufferedReader br) throws IOException {
        String orderList[] = new String[3];

        System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
        System.out.println("[안내] 주문자 이름을 알려주세요!");
        System.out.print(">>> ");
        orderList[0] = br.readLine();

        System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        orderList[1] = br.readLine();

        System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
        System.out.print(">>> ");
        orderList[2] = br.readLine();

        Order order = new Order(orderList[0]
                , orderList[1]
                , orderList[2]);

        shopRepository.orderFood(order);
    }

    @Override
    public void selectFeedback(BufferedReader br) throws IOException {
        String feedbackList[] = new String[4];

        System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
        System.out.println("[안내] 주문자 이름은 무엇인가요?");
        System.out.print(">>> ");
        feedbackList[0] = br.readLine();

        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        System.out.print(">>> ");
        feedbackList[1] = br.readLine();

        System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
        System.out.print(">>> ");
        feedbackList[2] = br.readLine();

        System.out.println("[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)");
        System.out.print(">>> ");
        feedbackList[3] = br.readLine();
        System.out.println("리뷰 등록 완료");

        Review review = new Review(feedbackList[0]
                , feedbackList[1]
                , feedbackList[2]
                , Integer.parseInt(feedbackList[3]));

        reviewRepository.registerReview(review);
    }

    @Override
    public void close() {
        System.out.println("[안내] 이용해주셔서 감사합니다.");
    }
}

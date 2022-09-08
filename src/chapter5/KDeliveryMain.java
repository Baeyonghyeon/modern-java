package chapter5;

import chapter5.Menu.impl.SelectMenuImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KDeliveryMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SelectMenuImpl selectMenu = new SelectMenuImpl();

        label : while (true){
            switch (mainMenu(br)){
                case 1 : selectMenu.selectAddShopMenu(br);
                    break;
                case 2 : selectMenu.selectDashboardMenu();
                    break;
                case 3 : selectMenu.selectOrderMenu(br);
                    break;
                case 4 : selectMenu.selectFeedback(br);
                    break;
                case 5 : selectMenu.close();
                         br.close();
                    break label;
            }
        }

    }

    public static int mainMenu(BufferedReader br) throws IOException {
        System.out.println("[치킨의 민족 프로그램 V1.0]");
        System.out.println("-".repeat(30));
        System.out.println("1) [사장님용] 음식점 등록하기");
        System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
        System.out.println("3) [고객님용] 음식 주문하기");
        System.out.println("4) [고객님용] 별점 등록하기");
        System.out.println("5) 프로그램 종료하기");
        System.out.println("-".repeat(30));

        System.out.println("[시스템] 무엇을 도와드릴까요?");
        System.out.print(">>> ");
        return Integer.parseInt(br.readLine());
    }

}
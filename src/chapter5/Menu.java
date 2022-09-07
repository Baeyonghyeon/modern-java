//package chapter5;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.InputMismatchException;
//import java.util.List;
//
//public class Menu {
//
//    private final BufferedReader br;
//
//    public Menu() {
//        this.br = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    public int mainMenu() {
//        System.out.println("[치킨의 민족 프로그램 V1]");
//        System.out.println("-".repeat(30));
//        System.out.println("1) [사장님용] 음식점 등록하기");
//        System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
//        System.out.println("3) [고객님용] 음식 주문하기");
//        System.out.println("4) [고객님용] 별점 등록하기");
//        System.out.println("5) 프로그램 종료하기");
//        System.out.println("-".repeat(30));
//
//        System.out.println("[시스템] 무엇을 도와드릴까요?");
//        System.out.println(">>> ");
//
//        while (true) {
//            try {
//                int selectNum = Integer.parseInt(br.readLine());
//                if (selectNum > 0 && selectNum < 6) {
//                    return selectNum;
//                }
//            } catch (InputMismatchException e) {
//                throw new InputMismatchException("입력 오류 1~5 정수값을 입력해주세요.");
//            } catch (IOException e) {
//                throw new RuntimeException("시스템 오류.");
//            }
//        }
//    }
//
//    //todo : 1) 음식점 & 대표음식 등록
//    // 객체를 만들어 return 하고 중복 예외처리를 그후에 하는게 좋을거 같다.
//    public String[] selectAddShopMenu() throws IOException {
//        String addList[] = new String[3];
//
//        System.out.println("[안내] 반갑습니다. 가맹주님!");
//        System.out.println("[안내] 음식점 상호는 무엇인가요?");
//        System.out.println(">>> ");
//        addList[0] = br.readLine();
//
//        System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
//        System.out.println(">>> ");
//        addList[1] = br.readLine();
//
//        System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
//        System.out.println(">>> ");
//        addList[2] = br.readLine();
//
//        return addList;
//    }
//
//    //todo : 2) 음식점 별점 조회하기
//    // 일단 모든 인원 출력 하는것으로 (+인원 검색, +가게 검색, +)
//    public void selectDashboardMenu(List<Food> reviewList) {
//        for (Food food : reviewList) {
//            System.out.println();
//        }
//
//
//    }
//
//    //todo : 3)음식 주문하기
//    // 객체를 만들어 return 하고 중복 예외처리를 그 후에 하는게 좋을거 같다.
//    public String[] selectOrderMenu() throws IOException {
//        String orderList[] = new String[3];
//
//        System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
//        System.out.println("[안내] 주문자 이름을 알려주세요!");
//        System.out.println(">>> ");
//        orderList[0] = br.readLine();
//
//        System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
//        System.out.println(">>> ");
//        orderList[1] = br.readLine();
//
//        System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
//        System.out.println(">>> ");
//        orderList[2] = br.readLine();
//
//        return orderList;
//    }
//
//
//    //todo : 4)별점 등록하기
//    // 객체 만들어 return 하고 중복 신경x
//    public String[] selectFeedback() throws IOException {
//        String feedbackList[] = new String[4];
//
//        System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
//        System.out.println("[안내] 주문자 이름은 무엇인가요?");
//        System.out.println(">>> ");
//        feedbackList[0] = br.readLine();
//
//        System.out.println("[안내] 음식점 상호는 무엇인가요?");
//        System.out.println(">>> ");
//        feedbackList[1] = br.readLine();
//
//        System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
//        System.out.println(">>> ");
//        feedbackList[2] = br.readLine();
//
//        System.out.println("[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)");
//
//        try {
//
//        }
//        feedbackList[3] = br.readLine();
//
//
//    }
//
//
//    //todo : 프로그램 종료하기
//    // 하지만 br.close()를 해버리면 다른 이용자가 에러가 발생하지 않을까?
//    public void close() throws IOException {
//        br.close();
//        System.out.println("[안내] 이용해주셔서 감사합니다.");
//    }
//
//}

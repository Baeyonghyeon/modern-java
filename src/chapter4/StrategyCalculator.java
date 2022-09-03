package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StrategyCalculator {

    /**
     * Strategy Pattern Calculator
     **/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LambdaOperand lambdaOperand = new LambdaOperand();
        initTerminal();

        while (true) {
            try {
                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input);

                System.out.println(lambdaOperand.calculate(Double.parseDouble(st.nextToken())
                        , st.nextToken()
                        , Double.parseDouble(st.nextToken())) + " 입니다.");
            } catch (Exception e) {

                System.out.println("잘못된 입력");
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        br.close();
    }

    public static void initTerminal() {
        System.out.println("계산기입니다.");
        System.out.println("다음 예시처럼 수식을 입력해 주세요.");
        System.out.println("ex) 2 + 3");
        System.out.println("종료키는 아무키나 누르면 됩니다.");
        System.out.println("-".repeat(30));
    }
}
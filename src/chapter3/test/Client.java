package chapter3.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {

        /**
         * 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
         * 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
         * 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
         * 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
         * 5. 밀라노에 거래자가 있는가?
         * 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
         * 7. 전체 트랜잭션 중 최댓값은 얼마인가?
         * 8. 전체 트랜잭션 중 최솟값은 얼마인가?
         */
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        List<Transaction> solution1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("solution1 : " + solution1);

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> solution2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("solution2 : " + solution2);

        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        List<Trader> solution3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("solution3 :" + solution3);

        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        List<Trader> solution4 = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("solution4 : " + solution4);

        // 5. 밀라노에 거래자가 있는가?
        boolean solution5 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getName().equals("Milan"));
        System.out.println("solution5 : " + solution5);

        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        List<Transaction> solution6 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.toList());
        System.out.println(solution6);

        // 7. 전체 트랜잭션 중 최댓값은 얼마인가?
        Optional<Integer> solution7 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("solution7 : " + solution7);

        // 8. 전체 트랜잭션 중 최솟값은 얼마인가?
        Optional<Integer> solution8 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println("solution8 : " + solution8);

        // 9. 전체 트랙잭션 중 최댓값인 트랜잭션값을 구하시오.
        Optional<Transaction> solution9 = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue));
        System.out.println("solution9 : " + solution9);
    }

}

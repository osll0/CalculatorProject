package com.example.calculator.lv2;

import java.util.LinkedList;
import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv2 calc = new CalculatorLv2();

        while (true) {
            String input;
            long num1, num2;

            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                input = sc.next();
                try {
                    num1 = Long.parseLong(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요!");
                }
            }

            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                input = sc.next();
                try {
                    num2 = Long.parseLong(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요!");
                }
            }

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            input = sc.next();
            char operator = input.charAt(0);

            try {
                long result = calc.calculate(num1, num2, operator);
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            boolean proceed = false;
            while (!proceed) {
                System.out.println("\n메뉴를 선택하세요.");
                System.out.println("1. 오래된 결과 삭제");
                System.out.println("2. 결과 목록 확인");
                System.out.println("3. 결과 목록 초기화");
                System.out.println("4. 넘어가기");
//                System.out.println("그 외 입력은 다음 계산으로 넘어갑니다.");
                input = sc.next();

                switch (input) {
                    case "1" -> {
                        calc.removeOldestResult();
                        System.out.println("삭제 후 결과 목록: " + calc.getResults());
                    }
                    case "2" -> System.out.println("현재 결과 목록: " + calc.getResults());
                    case "3" -> {
                        calc.setResults(new LinkedList<>());
                        System.out.println("결과 목록이 초기화되었습니다.");
                    }
                    case "4" -> proceed = true;
                    default -> System.out.println("잘못된 입력입니다.");
                }
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            sc.nextLine();
            input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
        }
    }
}
package com.example.calculator.lv3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

public class AppLv3 {
    private static final DecimalFormat DF = new DecimalFormat("0.##########");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculatorLv3<Double> calc = new ArithmeticCalculatorLv3<>();

        while (true) {
            String input;
            double num1, num2;

            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                input = sc.next();
                try {
                    num1 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요!");
                }
            }

            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                input = sc.next();
                try {
                    num2 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요!");
                }
            }

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            input = sc.next();

            try {
                OperatorTypeLv3 op = OperatorTypeLv3.fromChar(input.charAt(0));
                double result = calc.calculate(num1, num2, op);
                System.out.println(DF.format(num1) + " " + op.getSymbol() + " " + DF.format(num2) + " = " + DF.format(result));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            boolean proceed = false;
            while (!proceed) {
                System.out.println("\n메뉴를 선택하세요.");
                System.out.println("1. 오래된 결과 삭제");
                System.out.println("2. 전체 결과 목록 확인");
                System.out.println("3. 결과 목록 초기화");
                System.out.println("4. 결과 값 조회");
                System.out.println("5. 넘어가기");
                input = sc.next();

                switch (input) {
                    case "1" -> {
                        calc.removeOldestResult();
                        System.out.println("삭제 후 결과 목록: [" + formatList(calc.getResults()) + "]");
                    }
                    case "2" -> System.out.println("현재 결과 목록: [" + formatList(calc.getResults()) + "]");
                    case "3" -> {
                        calc.setResults(new LinkedList<>());
                        System.out.println("결과 목록이 초기화되었습니다.");
                    }
                    case "4" -> {
                        double threshold;
                        while (true) {
                            System.out.print("조회 기준 값을 입력하세요: ");
                            input = sc.next();
                            try {
                                threshold = Double.parseDouble(input);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("기준값를 입력해주세요!");
                            }
                        }
                        List<Double> filteredResults = calc.getResultsGreaterThan(threshold);
                        if (filteredResults.isEmpty())
                            System.out.println("조건을 만족하는 결과가 없습니다!");
                        else
                            System.out.println("조회 결과: [" + formatList(filteredResults) + "]");
                    }
                    case "5" -> proceed = true;
                    default -> System.out.println("잘못된 입력입니다.");
                }
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            sc.nextLine();
            input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
        }
    }
    private static String formatList(List<Double> list) {
        return list.stream()
                .map(DF::format)
                .collect(Collectors.joining(", "));
    }
}
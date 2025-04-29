package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input;
            int num1 = 0, num2 = 0;

            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                input = sc.next();
                try {
                    num1 = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요!");
                }
            }

            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                input = sc.next();
                try {
                    num2 = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요!");
                }
            }

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            input = sc.next();
            char operator = input.charAt(0);

            int result = 0;
            boolean isValid = true;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        isValid = false;
                        System.out.println("0으로는 나눌 수 없습니다!");
                    }
                    else
                        result = num1 / num2;
                    break;
                default:
                    isValid = false;
                    System.out.println("올바르지 못한 연산 기호입니다!");
                    break;
            }
            if (isValid)
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            sc.nextLine();
            input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
        }
    }
}

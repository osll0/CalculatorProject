package com.example.calculator;

import java.util.Scanner;

/* 요구사항 정의 및 설계
1. 요구사항 정의 (Lv,1)
- 2개의 정수와 사칙연산 될 문자를 입력받음.
- "exit"를 입력할 때까지 값을 받고 연산 결과를 반환한다.
 */

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("exit")) break;
            int num1 = Integer.parseInt(input);
            System.out.print("두 번째 숫자를 입력하세요: ");
            input = sc.next();
            if (input.equalsIgnoreCase("exit")) break;
            int num2 = Integer.parseInt(input);


        }
    }
}

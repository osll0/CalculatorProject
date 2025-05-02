package com.example.calculator.lv3;

import java.util.LinkedList;
import java.util.Queue;

/* 요구사항 정의 및 설계
1. 요구사항 정의 (Lv,1)
- 2개의 정수와 사칙연산 될 문자를 입력받음.
- "exit"를 입력할 때까지 값을 받고 연산 결과를 반환한다.
 */

public class ArithmeticCalculatorLv3 {
    private final Queue<Long> results = new LinkedList<>();

    public long calculate(long a, long b, OperatorTypeLv3 operator) {
        long result = operator.apply(a, b);
        results.add(result);
        return result;
    }

    public Queue<Long> getResults() {
        return new LinkedList<>(results);
    }

    public void setResults(Queue<Long> newResults) {
        results.clear();
        results.addAll(newResults);
    }

    public void removeOldestResult() {
        if (!results.isEmpty()) results.poll();
    }
}

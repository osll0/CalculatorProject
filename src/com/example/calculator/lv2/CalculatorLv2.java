package com.example.calculator.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class CalculatorLv2 {
    private final Queue<Long> results = new LinkedList<>();

    public long calculate(long a, long b, char operator) {
        long result;
        switch (operator) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다!");
                result =  a / b;
            }
            default -> throw new IllegalArgumentException("올바르지 못한 연산 기호입니다!");
        }
        addResult(result);
        return result;
    }

    public Queue<Long> getResults() {
        return new LinkedList<>(results);
    }

    public void setResults(Queue<Long> newResults) {
        results.clear();
        results.addAll(newResults);
    }

    public void addResult(long result) {
        results.add(result);
    }

    public void removeOldestResult() {
        if (!results.isEmpty()) results.poll();
    }
}

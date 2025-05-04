package com.example.calculator.lv3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ArithmeticCalculatorLv3 {
    private final Queue<Long> results = new LinkedList<>();

    public long calculate(long a, long b, OperatorTypeLv3 operator) {
        long result = operator.apply(a, b);
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

    public List<Long> getResultsGreaterThan(long threshold) {
        return results.stream()
                .filter(r -> threshold < r)
                .collect(Collectors.toList());
    }
}

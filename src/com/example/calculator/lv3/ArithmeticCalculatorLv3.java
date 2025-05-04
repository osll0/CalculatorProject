package com.example.calculator.lv3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ArithmeticCalculatorLv3<T extends Number> {
    private final Queue<Double> results = new LinkedList<>();

    public double calculate(T a, T b, OperatorTypeLv3 operator) {
        double x = a.doubleValue();
        double y = b.doubleValue();
        double result = operator.apply(x, y);
        addResult(result);
        return result;
    }

    public List<Double> getResults() {
        return results.stream().toList();
    }

    public void setResults(Queue<Double> newResults) {
        results.clear();
        results.addAll(newResults);
    }

    public void addResult(double result) {
        results.add(result);
    }

    public void removeOldestResult() {
        if (!results.isEmpty()) results.poll();
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return results.stream()
                .filter(r -> r > threshold)
                .collect(Collectors.toList());
    }
}

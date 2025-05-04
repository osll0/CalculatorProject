package com.example.calculator.lv3;

import java.util.function.DoubleBinaryOperator;

public enum OperatorTypeLv3 {
    ADD('+', (x, y) -> x + y),
    SUBTRACT('-', (x, y) -> x - y),
    MULTIPLY('*', (x, y) -> x * y),
    DIVIDE('/', (x, y) -> {
        if (y == 0.0) throw new ArithmeticException("0으로 나눌 수 없습니다!");
        return x / y;
    });

    private final char symbol;
    private final DoubleBinaryOperator operator;
    OperatorTypeLv3(char symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public double apply(double x, double y) {return operator.applyAsDouble(x, y);}
    public char getSymbol() {return symbol;}

    public static OperatorTypeLv3 fromChar(char operator) {
        return switch (operator) {
            case '+' -> ADD;
            case '-' -> SUBTRACT;
            case '*' -> MULTIPLY;
            case '/' -> DIVIDE;
            default -> throw new IllegalArgumentException("올바르지 못한 연산 기호입니다!");
        };
    }
}

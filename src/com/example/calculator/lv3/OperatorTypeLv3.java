package com.example.calculator.lv3;

import java.util.function.LongBinaryOperator;

public enum OperatorTypeLv3 {
    ADD('+', (x, y) -> x + y),
    SUBTRACT('-', (x, y) -> x - y),
    MULTIPLY('*', (x, y) -> x * y),
    DIVIDE('/', (x, y) -> {
        if (y == 0) throw new ArithmeticException("0으로 나눌 수 없습니다!");
        return x / y;
    });

    private final char symbol;
    private final LongBinaryOperator operator;
    OperatorTypeLv3(char symbol, LongBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public long apply(long x, long y) {return operator.applyAsLong(x, y);}
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

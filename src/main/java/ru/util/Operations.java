package ru.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Operations {
    private static List<String> operations;
    public static final String ADDITIONAL = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";

    public static List<String> getOperation() {
        if (operations == null) {
            return operations = Arrays.asList(ADDITIONAL, SUBTRACTION, MULTIPLICATION, DIVISION);
        }
        return operations;
    }

    public static double selectOperationAndGetResult(String operation, List<Double> params) {
        double result = 0;
        switch (operation) {
            case ADDITIONAL:
                result = additional(params);
                break;
            case SUBTRACTION:
                if (subtraction(params).isPresent()) {
                    result = subtraction(params).get();
                    break;
                }
            case MULTIPLICATION:
                if (multiplication(params).isPresent()) {
                    result = multiplication(params).get();
                    break;
                }
            case DIVISION:
                if (!params.get(1).equals(0.00)) {
                    result = division(params).get();
                }
                break;
        }
        return result;
    }

    private static double additional(List<Double> params) {
        return params.stream().reduce(0.0, Double::sum);
    }

    private static Optional<Double> subtraction(List<Double> params) {
        return params.stream().reduce((a, b) -> a - b);
    }

    private static Optional<Double> multiplication(List<Double> params) {
        return params.stream().reduce((a, b) -> a * b);
    }

    private static Optional<Double> division(List<Double> params) {
        return params.stream().reduce((a, b) -> a / b);
    }
}

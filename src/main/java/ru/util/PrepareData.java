package ru.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для подготовки данных
 *
 * @author Gordeev M.A.
 */
public class PrepareData {

    /**
     * Метод проверяет, и возвращает арифметическое действие
     *
     * @param expression передаваемое выражение калькулятору
     * @return корректное ли арифмитеческое действие
     */
    public static String checkAndReturnOperation(String expression) {
        for (String operation : Operations.getOperation()) {
            if (expression.contains(operation)) {
                return getMathOperation(expression);
            }
        }
        System.err.println("Допустимые операции: +,-,/,*");
        return null;
    }

    /**
     * Метод преобразует передаваемую строку в список операндов
     *
     * @param expression передаваемое выражение калькулятору
     * @return массив операндов
     */
    public static List<Double> prepareOperands(String expression) {
        List<Double> data = new ArrayList<>();
        while (expression.contains(" ")) {
            expression = expression.replace(" ", "");
        }

        for (String element : expression.split("[-*/+]")) {
            try {
                data.add(Double.valueOf(element));
            } catch (NumberFormatException e) {
                System.err.println("Введите два числа");
                return null;
            }
        }
        return data;
    }

    private static String getMathOperation(String expression) {
        String operation = null;
        for (String element : Operations.getOperation()) {
            if (expression.contains(element)) {
                operation = expression.substring(expression.indexOf(element), expression.indexOf(element) + 1);
            }
        }
        return operation;
    }
}

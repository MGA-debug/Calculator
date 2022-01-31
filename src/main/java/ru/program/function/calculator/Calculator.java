package ru.program.function.calculator;

import ru.program.util.MyScanner;
import ru.program.util.constant.Command;

import java.util.List;

public class Calculator {

    /**
     * Основная логика калькулятора
     *
     *
     * @return true и результат если выражение корректно, false и предупреждающее сообщение если выражение некоректно
     */
    public static boolean calculated() {
        System.out.println("Калькулято запущен ... \nПример запроса: 1 + 2");
        String data = MyScanner.getScanner().nextLine();

        String operation = PrepareData.checkAndReturnOperation(data);
        List<Double> parameters = PrepareData.prepareOperands(data);
        if (operation == null || parameters == null) {
            return false;
        }

        double result = Operations.selectOperationAndGetResult(operation, parameters);
        System.out.println("Результат: ");
        System.out.printf("%+.4f", result);
        System.out.println("");
        Command.getInformationMessage();
        return true;
    }
}

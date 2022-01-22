package ru.util;

import java.util.List;
import java.util.Scanner;

/**
 * @author Gordeev M.A.
 */
public class Calculator {


    /**
     * Основная логика. Запуск калькулятора, проверка корректности данных, форматирование и вывод результата
     *
     */
    public static void start() {
        System.out.println("Калькулято запущен ...");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            if ("exit".equals(data)) {
                scanner.close();
            }

            String operation = PrepareData.checkAndReturnOperation(data);
            List<Double> parameters = PrepareData.prepareOperands(data);
            if (operation == null || parameters == null) {
                continue;
            }

            double result = Operations.selectOperationAndGetResult(operation, parameters);
            System.out.println("Результат: ");
            System.out.printf("%+020.4f", result);
            System.out.println();
            System.out.println("Для завершения работы введите \"exit\"");
        }
    }
}

package ru.appline;

import ru.program.function.calculator.Calculator;
import ru.program.function.finder.WorkWithArray;
import ru.program.util.MyScanner;
import ru.program.util.constant.Command;


/**
 * @author Gordeev M.A.
 */
public class Program {

    /**
     * Основная логика. Запуск и выбор программы
     */
    public static void start() {
        String data;
        Command.getMenuMessage();

        while (MyScanner.getScanner().hasNextLine()) {
            data = MyScanner.getScanner().nextLine();
            switch (data) {
                case Command.MENU:
                    Command.getMenuMessage();
                    continue;
                case Command.EXIT:
                    MyScanner.getScanner().close();
                    return;
                case "1":
                    if (!Calculator.calculated()) {
                        Command.getMenuMessage();
                    }
                    break;
                case "2":
                    if (!WorkWithArray.findLargestWord()) {
                        Command.getMenuMessage();
                    }
                    break;
                default:
                    Command.getMenuMessage();
                    break;
            }
        }
    }
}

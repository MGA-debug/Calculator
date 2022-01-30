package ru.program.function.finder;

import ru.program.util.MyScanner;
import ru.program.util.constant.Command;

import java.util.Arrays;
import java.util.Comparator;

public class WorkWithArray {

    private static String[] words;

    public static boolean findLargestWord() {

        System.out.println("Введите количество слов");
        String inputSize = MyScanner.getScanner().nextLine();
        System.out.println("Введите слова в одну строку через пробел");
        String allWord = MyScanner.getScanner().nextLine();

        if (setLength(inputSize)) {
            if (!fillArray(allWord)) {
                return false;
            }
            System.out.println("Исходный массив " + Arrays.toString(words));
            System.out.println("Самое длинное слово: " + getLargestWord(words));
            Command.getInformationMessage();
            return true;
        }
        return false;
    }

    /**
     *
     * @param length передаваемая размерность для массива
     *
     * @return является ли передаваемый параметр числом
     */
    private static boolean setLength(String length) {
        int size;
        try {
            size = Integer.parseInt(length);
        } catch (NumberFormatException e) {
            System.err.println("Введите число");
            return false;
        }
        words = new String[size];
        return true;
    }


    /**
     *
     * @param inputString передаваемая строка
     *
     * @return соответствует ли количество передаваемых слов с заданным
     */
    private static boolean fillArray(String inputString) {
        String[] inputWords = inputString.split(" ");
        if (words.length != inputWords.length) {
            System.err.println("Количество переданных слов отличается от ожидаемого.\nОжидается: " + words.length + " ," +
                    "передано: " + inputWords.length);
            return false;
        }
        words = inputWords;
        return true;
    }

    private static String getLargestWord(String[] words) {
        return Arrays.stream(words).max(Comparator.comparingInt(String::length)).get();
    }
}

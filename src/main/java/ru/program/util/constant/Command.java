package ru.program.util.constant;

public class Command {
    public static final String EXIT = "выход";
    public static final String MENU = "меню";

    public static void getInformationMessage() {
        System.out.println("Для завершения работы введите \"выход\"");
        System.out.println("Для возврата в меню введите \"меню\"");
    }

    public static void getMenuMessage() {
        System.out.println("Выберите задание: \n 1. Калькулятор \n 2. Поиск самого длинного слова");
    }
}

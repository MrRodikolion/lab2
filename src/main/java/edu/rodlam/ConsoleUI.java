package edu.rodlam;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;


public class ConsoleUI {
    private Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);


    public String getUserQuery() {
        System.out.print("Введите запрос:");
        String inputLine = in.nextLine();
        boolean empty = inputLine.trim().isEmpty();
        while (empty) {
            empty = inputLine.trim().isEmpty();
            System.out.println("Вы не ввели запрос");
            inputLine = getUserQuery();
        }
        return inputLine;
    }

    public boolean displayResults(List<SearchResult> output) {
        if (output.isEmpty()) {
            System.out.print("Нет результатов \n");
            return false;
        }
        System.out.print("Результат запроса: \n");
        String getter = null;
        for (int i = 0; i < output.size(); i++) {
            getter = output.get(i).getTitle();
            System.out.println(i + ") " + getter);
        }
        return true;
    }


    public Integer getUserChoice() {
        Integer userChoice = null;
        System.out.print("Какую открыть?: \n");
        String inpLine = in.nextLine().trim();
        try {
            userChoice = Integer.valueOf(inpLine);
        } catch (NumberFormatException e) {
            System.out.print("введите число пожалуйста( ");
        }
        return userChoice;
    }

    public Boolean askContinue() {
        boolean empty = false;
        String inputLine = null;
        while (inputLine == null) {
            System.out.print("Хотите продолжить? (y/n): ");
            inputLine = in.nextLine();
            empty = inputLine.trim().isEmpty();

        }


        if (empty) {
            System.out.println("Вы не ввели ответ");
            return askContinue();
        }
        if (inputLine.equalsIgnoreCase("y")) {
            return true;
        } else if (inputLine.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Неверный ввод. Пожалуйста, введите 'y' или 'n'.");
            return askContinue();
        }

    }
}
package edu.rodlam;

import java.util.List;
import java.util.Scanner;
import java.net.URLEncoder;


public class ConsoleUI {
    public String getUserQuery() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите запрос:");
        String inputLine = in.nextLine();
        boolean empty = inputLine.trim().isEmpty();

        if (empty) {
            System.out.println("Вы не ввели запрос");
            inputLine = getUserQuery();
        }
        return inputLine;
    }

   public void displayResults(List<SearchResult> output) {

       System.out.print("Результат запроса:");
       String getter;
       for (int i = 0; i <= output.size(); i++) {
           getter = output.get(i).getTitle();
           System.out.println(i+1 + ") " + getter);
       }
   }
    public Integer getUserChoice() {
        Scanner in = new Scanner(System.in);
         System.out.print("Какую открыть?: \n");
         Integer num = in.nextInt(); 
         in.close();
            return num;

}
    public Boolean askContinue() {
        Scanner in = new Scanner(System.in);
        System.out.print("Хотите продолжить? (y/n): ");
        String inputLine = in.nextLine();
        boolean empty = inputLine.trim().isEmpty();

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
package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Learning Progress Tracker");

        Scanner scanner = new Scanner(System.in);
        String theCommand = scanner.nextLine();
        String result = theCommand.equals("exit") ? "Bye"
                : theCommand.isBlank()? "No input."
                : "Unknown command!";
        System.out.println(result);
    }
}

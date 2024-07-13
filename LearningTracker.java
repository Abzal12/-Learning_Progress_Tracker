package tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class LearningTracker {

    MenuStatus currentStatus = MenuStatus.BEGINNING;
    ArrayList<Student> students = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startLearningTrackerProcess() {
        System.out.println("Learning Progress Tracker!");
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "add students" -> addStudents();
                case "exit" -> {
                    exit();
                    return;
                }
                case "back" -> back();
            }
        }
    }

    public void addStudents() {
        currentStatus = MenuStatus.ADDING;
        System.out.println("Enter student credentials or 'back' to return");

        //String[] studentCredentials = scanner.nextLine().split(" ");
        do {
            String userChoice = scanner.nextLine();
            if (userChoice.equals("back")) {
                back();
                break;
            } else {
                String studentCredentials = userChoice;
                Validation.credentialsValidation(studentCredentials, students);
            }
        } while (true);
    }

    public void back() {
        switch (currentStatus) {
            case ADDING -> {
                System.out.printf("Total %d students have been added.\n", students.size());
                currentStatus = MenuStatus.BEGINNING;
            }
            case BEGINNING -> System.out.println("Enter 'exit' to exit the program");
        }
    }

    public void exit() {
        System.out.println("Bye!");
    }
}

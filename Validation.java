package tracker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String NAME_PATTERN
            = "^(?!['-])(?!.*['-]{2})[A-Za-z]+(?:['-]?[A-Za-z]+)*(?<!['-])( (?!['-])(?!.*['-]{2})[A-Za-z]+(?:['-]?[A-Za-z]+)*(?<!['-]))*$";
    private static final Pattern pattern = Pattern.compile(NAME_PATTERN);

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static void credentialsValidation(String studentCredentials, ArrayList<Student> students) {
        if (studentCredentials.split(" ").length < 3) {
            System.out.println("Incorrect credentials.");
            return;
        }

        int lastBlank = studentCredentials.lastIndexOf(" ");
        String fullName = studentCredentials.substring(0, lastBlank);
        String email = studentCredentials.substring(lastBlank + 1);

        if (getFirstName(fullName) == null) {
            System.out.println("Incorrect first name.");
        } else if (getLastName(fullName) == null) {
            System.out.println("Incorrect last name.");
        } else if (getEmail(email) == null) {
            System.out.println("Incorrect email.");
        } else {
            students.add(new Student(getFirstName(fullName), getLastName(fullName), getEmail(email)));
            System.out.println("The student has been added.");
        }
    }

    public static String getFirstName(String studentFullName) {
        String firstName = splitFullName(studentFullName)[0];
        if (isValidName(firstName)) {
            return firstName;
        }
        return null;
    }

    private static String getLastName(String studentFullName) {
        String lastName = splitFullName(studentFullName)[1];
        if (isValidName(lastName)) {
            return lastName;
        }
        return null;
    }

    private static boolean isValidName(String name) {
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static String[] splitFullName(String fullName) {
        if (fullName.length() > 20) {
            String[] parts = fullName.split(" ", 2);
            String firstName = parts[0];
            String lastName = parts.length > 1 ? parts[1] : "";
            return new String[]{firstName, lastName};
        } else {
            return fullName.split(" ");
        }
    }

    private static String getEmail(String email) {
        if (isValidEmail(email)) {
            return email;
        }
        return null;
    }

    private static boolean isValidEmail(String email) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
}

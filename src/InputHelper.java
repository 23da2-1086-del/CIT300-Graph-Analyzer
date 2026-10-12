import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * InputHelper  (Member 2)
 * Reads and validates user input so the program never crashes
 * when the user types letters instead of numbers, or nothing at all.
 * All menus in the project use this one class.
 */
public class InputHelper {

    // One shared Scanner for the whole program (do not create other Scanners!)
    private static final Scanner scanner = new Scanner(System.in);

    // Reads one line of text. If the input stream is closed, the program exits politely.
    private static String readLine(String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            System.out.println("\nNo more input available. Exiting program.");
            System.exit(0);
            return "";
        }
    }

    // Keeps asking until the user types a whole number.
    public static int readInt(String prompt) {
        while (true) {
            String line = readLine(prompt);
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number (for example 25).");
            }
        }
    }

    // Keeps asking until the number is between min and max (inclusive).
    public static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Invalid input! Please enter a number between " + min + " and " + max + ".");
        }
    }

    // Reads one word (no spaces, not empty). Used for graph vertex names.
    public static String readWord(String prompt) {
        while (true) {
            String line = readLine(prompt);
            if (line.isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else if (line.contains(" ")) {
                System.out.println("Please enter a single word without spaces.");
            } else {
                return line;
            }
        }
    }

    // Asks a yes/no question. Returns true for yes.
    public static boolean readYesNo(String prompt) {
        while (true) {
            String line = readLine(prompt + " (y/n): ").toLowerCase();
            if (line.equals("y") || line.equals("yes")) {
                return true;
            }
            if (line.equals("n") || line.equals("no")) {
                return false;
            }
            System.out.println("Please type y or n.");
        }
    }
}

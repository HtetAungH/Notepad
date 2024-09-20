
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Notepad {
    // HashMap to store notes with Title as the key and Note details as the value
    private static Map<String, String[]> notes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                // Display options for the user
                System.out.println("\nNotepad Program");
                System.out.println("1. Add Note");
                System.out.println("2. Edit Note");
                System.out.println("3. Search Note");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        addNote();
                        break;
                    case 2:
                        editNote();
                        break;
                    case 3:
                        searchNote();
                        break;
                    case 4:
                        System.out.println("Exiting Notepad. Goodbye!");
                        return; // Exit the program
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    // Function 1: Add a new note
    public static void addNote() {
        try {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter Date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("Enter Memo: ");
            String memo = scanner.nextLine();

            // Save note with Title as key and an array of [date, memo] as value
            notes.put(title, new String[]{date, memo});
            System.out.println("Note added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding note: " + e.getMessage());
        }
    }

    // Function 2: Edit a note by Title
    public static void editNote() {
        try {
            System.out.print("Enter the Title of the note to edit: ");
            String title = scanner.nextLine();

            // Check if the note exists
            if (notes.containsKey(title)) {
                String[] noteDetails = notes.get(title);
                System.out.println("Current Memo: " + noteDetails[1]);

                System.out.print("Enter new Memo: ");
                String newMemo = scanner.nextLine();

                // Update the memo in the existing note
                notes.put(title, new String[]{noteDetails[0], newMemo});
                System.out.println("Memo updated successfully.");
            } else {
                System.out.println("Note not found with the title: " + title);
            }
        } catch (Exception e) {
            System.out.println("Error editing note: " + e.getMessage());
        }
    }

    // Function 3: Search a note by Title
    public static void searchNote() {
        try {
            System.out.print("Enter the Title of the note to search: ");
            String title = scanner.nextLine();

            // Check if the note exists and display it
            if (notes.containsKey(title)) {
                String[] noteDetails = notes.get(title);
                System.out.println("\nNote Details:");
                System.out.println("Title: " + title);
                System.out.println("Date: " + noteDetails[0]);
                System.out.println("Memo: " + noteDetails[1]);
            } else {
                System.out.println("Note not found with the title: " + title);
            }
        } catch (Exception e) {
            System.out.println("Error searching note: " + e.getMessage());
        }
    }
}


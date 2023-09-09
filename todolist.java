import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class todolist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add task");
            System.out.println("2. Mark task as complete");
            System.out.println("3. View tasks");
            System.out.println("4. Remove task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    tasks.add(new Task(description));
                    break;
                case 2:
                    System.out.print("Enter task number to mark as complete: ");
                    int completedTaskNumber = scanner.nextInt();
                    if (completedTaskNumber > 0 && completedTaskNumber <= tasks.size()) {
                        tasks.get(completedTaskNumber - 1).setComplete(true);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 3:
                    System.out.println("Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;
                case 4:
                    System.out.print("Enter task number to remove: ");
                    int removeTaskNumber = scanner.nextInt();
                    if (removeTaskNumber > 0 && removeTaskNumber <= tasks.size()) {
                        tasks.remove(removeTaskNumber - 1);
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return description + (isComplete ? " (Completed)" : "");
    }
}


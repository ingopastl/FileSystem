import java.util.Scanner;

public class Main {
    private static void processInput(String input) {
        if (input.equals("help")) {
            printHelp();
        }
    }

    private static void printHelp() {
        System.out.println("List of available commands:");
        System.out.println("ls - View the current directory's content.");
        System.out.println("cd - Go to a directory.");
        System.out.println("mkdir - Create a directory.");
        System.out.println("rm - Delete a file or directory.");
        System.out.println("touch - Create a file.");
    }

    public static void main(String[] args) {
        Directory currentDirectory = Memory.getRoot();

        System.out.println("---------Welcome to your file system---------");
        System.out.println("Type 'help' if you want to see the available commands.");
        System.out.println("Current path: " + currentDirectory.getName() + "");

        while (true) {
            Scanner reader = new Scanner(System.in);
            String input = reader.next();
            processInput(input);
        }
    }
}

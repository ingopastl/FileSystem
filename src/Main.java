import java.util.Scanner;

public class Main {
    static private Directory currentDirectory = Memory.getRoot();

    private static void processInput(String input) {
        System.out.println("Current path: " + currentDirectory.getName() + "");
        System.out.println("------------------");

//        switch (input){
//            case "help": printHelp();
//                break;
//            case "ls":
//                break;
//            default:
//                System.out.println("Not a command.");
//                break;
//        }
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


        System.out.println("---------Welcome to your file system---------");
        System.out.println("Current path: " + currentDirectory.getName() + "");
        System.out.println("------------------");
        System.out.println("Type 'help' if you want to see the available commands.");

        while (true) {
            Scanner reader = new Scanner(System.in);
            String input = reader.next();
            processInput(input);
        }
    }
}

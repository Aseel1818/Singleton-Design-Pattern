import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /** If multiple components in the application should write on the same text file then we use the
         Singleton to ensure all writers writes on the same file and managed through a single instance ,
         it will help also with avoiding conflicts and synchronization **/

        File file = File.getInstance();
        while (true){
            System.out.println("Please write a message to write or exit to out");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            if(message.equalsIgnoreCase("exit")){
                break;
            }
            file.write(message);
        }
    }
}
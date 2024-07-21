import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    private static File instance;
    private BufferedWriter writer;


    private File() {
        try {
            writer = new BufferedWriter(new FileWriter("outputFile.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** If multiple components in the application should write on the same text file then we use the
    Singleton to ensure all writers writes on the same file and managed through a single instance ,
     it will help also with avoiding conflicts and synchronization **/

    public static File getInstance() {
        if (instance == null) {
            synchronized (File.class) {
                if (instance == null) {
                    instance = new File();
                }
            }
        }
        return instance;
    }


    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
            System.out.println("******* Message written successfully **********");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

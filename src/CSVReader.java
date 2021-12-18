import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {

    private Scanner scanner;

    public void readFile() throws FileNotFoundException {
        scanner = new Scanner(new File("inventory.csv"));

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }










    public static void main(String[] args) throws FileNotFoundException {
        //For Testing
        CSVReader csvReader = new CSVReader();
        csvReader.readFile();
    }
}

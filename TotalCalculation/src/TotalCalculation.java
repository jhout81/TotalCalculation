import java.io.*;
import java.util.Scanner;

public class TotalCalculation {
    public static void main(String[] args) throws FileNotFoundException {

        File readItems = new File("items.txt");
        FileInputStream stream1 = new FileInputStream(readItems);
        Scanner scan = new Scanner(stream1);

        double fileIterate;
        double sum = 0;

        while (scan.hasNextDouble()) {
            fileIterate = scan.nextDouble();
            sum += fileIterate;
        }
        scan.close();

        FileOutputStream outPutStream1 = new FileOutputStream("total.txt");

        try {

            outPutStream1.write(("The sub-total is $" + String.format("%.2f", sum)).getBytes());
            outPutStream1.write(("\nThe tax is $" + String.format("%.2f", (sum * .053))).getBytes());
            outPutStream1.write(("\nThe total is $" + String.format("%.2f", (sum + (sum * .053)))).getBytes());
            outPutStream1.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

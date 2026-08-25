import javax.swing.JFileChooser;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductReader
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        JFileChooser chooser = new JFileChooser();

        Path filePath = null;

        boolean tryAgain = true;

        while(tryAgain)
        {
            int result = chooser.showOpenDialog(null);

            if(result == JFileChooser.APPROVE_OPTION)
            {
                filePath = chooser.getSelectedFile().toPath();
                tryAgain = false;
            }
            else
            {
                tryAgain = SafeInput.getYNConfirm(in, "No file selected. Try again?");
            }
        }

        // If the user cancels and chooses N, end the program normally.
        if(filePath == null)
        {
            return;
        }

        try
        {
            BufferedReader reader = Files.newBufferedReader(filePath);

            String line;

            System.out.println();

            System.out.println(String.format("%-8s %-15s %-30s %-10s",
                    "ID#", "Name", "Description", "Cost"));

            System.out.println("================================================================");

            while((line = reader.readLine()) != null)
            {
                String[] fields = line.split(",");

                String id = fields[0].trim();
                String name = fields[1].trim();
                String description = fields[2].trim();
                double cost = Double.parseDouble(fields[3].trim());

                System.out.println(String.format("%-8s %-15s %-30s %.2f",
                        id, name, description, cost));
            }

            reader.close();
        }
        catch(IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
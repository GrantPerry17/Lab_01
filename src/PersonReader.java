import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonReader
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

        if(filePath == null)
        {
            return;
        }

        ArrayList<Person> persons = new ArrayList<>();

        try
        {
            BufferedReader reader = Files.newBufferedReader(filePath);

            String line;

            while((line = reader.readLine()) != null)
            {
                String[] fields = line.split(",");

                String id = fields[0].trim();
                String firstName = fields[1].trim();
                String lastName = fields[2].trim();
                String title = fields[3].trim();
                int yearOfBirth = Integer.parseInt(fields[4].trim());

                Person person = new Person(firstName, lastName, id, title, yearOfBirth);

                persons.add(person);
            }

            reader.close();

            System.out.println();

            System.out.println(String.format("%-8s %-12s %-14s %-10s %s",
                    "ID#", "Firstname", "Lastname", "Title", "YOB"));

            System.out.println("================================================");

            for(Person person : persons)
            {
                System.out.println(String.format("%-8s %-12s %-14s %-10s %s",
                        person.getID(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getTitle(),
                        person.getYOB()));
            }
        }
        catch(IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
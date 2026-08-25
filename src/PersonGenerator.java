import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> persons = new ArrayList<>();

        boolean morePersons;

        do
        {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title");
            int yearOfBirth = SafeInput.getInt(in, "Enter Year of Birth");

            String personRecord = id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth;

            persons.add(personRecord);

            morePersons = SafeInput.getYNConfirm(in, "Enter another person?");
        } while(morePersons);

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name");

        try
        {
            Path filePath = Paths.get(fileName);

            BufferedWriter writer = Files.newBufferedWriter(filePath);

            for(String person : persons)
            {
                writer.write(person);
                writer.newLine();
            }

            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
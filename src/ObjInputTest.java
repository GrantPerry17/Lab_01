import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ObjInputTest
{
    @Test
    public void testGetNonZeroLenString()
    {
        Scanner scanner = new Scanner("Hello\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals("Hello", input.getNonZeroLenString("Enter text"));
    }

    @Test
    public void testGetRangedInt()
    {
        Scanner scanner = new Scanner("5\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals(5, input.getRangedInt("Enter number", 1, 10));
    }

    @Test
    public void testGetInt()
    {
        Scanner scanner = new Scanner("42\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals(42, input.getInt("Enter number"));
    }

    @Test
    public void testGetRangedDouble()
    {
        Scanner scanner = new Scanner("5.5\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals(5.5, input.getRangedDouble("Enter number", 1, 10));
    }

    @Test
    public void testGetDouble()
    {
        Scanner scanner = new Scanner("42.75\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals(42.75, input.getDouble("Enter number"));
    }

    @Test
    public void testGetYNConfirmYes()
    {
        Scanner scanner = new Scanner("Y\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertTrue(input.getYNConfirm("Continue?"));
    }

    @Test
    public void testGetYNConfirmNo()
    {
        Scanner scanner = new Scanner("N\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertFalse(input.getYNConfirm("Continue?"));
    }

    @Test
    public void testGetRegExString()
    {
        Scanner scanner = new Scanner("ABC123\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals("ABC123", input.getRegExString("Enter ID", "[A-Z]{3}[0-9]{3}"));
    }

    public static void main(String[] args)
    {
        SafeInputObj input = new SafeInputObj();

        String text = input.getNonZeroLenString("Enter a string");
        System.out.println("You entered: " + text);

        int rangedInt = input.getRangedInt("Enter an integer", 1, 100);
        System.out.println("You entered: " + rangedInt);

        int integer = input.getInt("Enter any integer");
        System.out.println("You entered: " + integer);

        double rangedDouble = input.getRangedDouble("Enter a decimal", 1, 100);
        System.out.println("You entered: " + rangedDouble);

        double decimal = input.getDouble("Enter any decimal");
        System.out.println("You entered: " + decimal);

        boolean confirmation = input.getYNConfirm("Do you want to continue?");
        System.out.println("You selected: " + confirmation);

        String regex = input.getRegExString("Enter three letters followed by three numbers", "[A-Z]{3}[0-9]{3}");
        System.out.println("You entered: " + regex);
    }
}
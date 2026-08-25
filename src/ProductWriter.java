import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> products = new ArrayList<>();

        boolean moreProducts;

        do
        {
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");

            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");

            String description = SafeInput.getNonZeroLenString(in, "Enter Product Description");

            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            String productRecord = id + ", " + name + ", " + description + ", " + cost;

            products.add(productRecord);

            moreProducts = SafeInput.getYNConfirm(in, "Enter another product?");

        } while(moreProducts);

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name");

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for(String product : products)
            {
                writer.write(product);
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
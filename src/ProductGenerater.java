import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerater
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();

        boolean moreProducts;

        do
        {
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            Product product = new Product(name, description, id, cost);

            products.add(product);

            moreProducts = SafeInput.getYNConfirm(in, "Enter another product?");
        }
        while(moreProducts);

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name");

        try
        {
            Path filePath = Paths.get(fileName);

            BufferedWriter writer = Files.newBufferedWriter(filePath);

            for(Product product : products)
            {
                writer.write(product.toCSV());
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
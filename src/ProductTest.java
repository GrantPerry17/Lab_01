import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest
{
    @Test
    public void testFullConstructor()
    {
        Product product = new Product("Laptop", "Dell laptop computer", "000001", 999.99);

        assertEquals("Laptop", product.getName());
        assertEquals("Dell laptop computer", product.getDescription());
        assertEquals("000001", product.getID());
        assertEquals(999.99, product.getCost());
    }

    @Test
    public void testOverloadedConstructor()
    {
        Product product = new Product("000002", 49.99);

        assertEquals("000002", product.getID());
        assertEquals(49.99, product.getCost());
    }

    @Test
    public void testSetName()
    {
        Product product = new Product("Laptop", "Dell laptop computer", "000001", 999.99);

        product.setName("Desktop");

        assertEquals("Desktop", product.getName());
    }

    @Test
    public void testSetDescription()
    {
        Product product = new Product("Laptop", "Dell laptop computer", "000001", 999.99);

        product.setDescription("Desktop computer");

        assertEquals("Desktop computer", product.getDescription());
    }

    @Test
    public void testSetCost()
    {
        Product product = new Product("Laptop", "Dell laptop computer", "000001", 999.99);

        product.setCost(1299.99);

        assertEquals(1299.99, product.getCost());
    }

    @Test
    public void testToCSV()
    {
        Product product = new Product("Laptop", "Dell laptop computer", "000001", 999.99);

        assertEquals("000001, Laptop, Dell laptop computer, 999.99", product.toCSV());
    }

    @Test
    public void testToJSON()
    {
        Product product = new Product("Laptop", "Dell laptop computer", "000001", 999.99);

        assertEquals(
                "{\"ID\":\"000001\",\"name\":\"Laptop\",\"description\":\"Dell laptop computer\",\"cost\":999.99}",
                product.toJSON());
    }

    @Test
    public void testToXML()
    {
        Product product = new Product("Laptop", "Dell laptop computer", "000001", 999.99);

        assertEquals(
                "<Product><ID>000001</ID><name>Laptop</name><description>Dell laptop computer</description><cost>999.99</cost></Product>",
                product.toXML());
    }

    @Test
    public void testToString()
    {
        Product product = new Product("Laptop", "Dell laptop computer", "000001", 999.99);

        assertEquals(
                "Product{name='Laptop', description='Dell laptop computer', ID='000001', cost=999.99}",
                product.toString());
    }

    @Test
    public void testEquals()
    {
        Product product1 = new Product("Laptop", "Dell laptop computer", "000001", 999.99);
        Product product2 = new Product("Laptop", "Dell laptop computer", "000001", 999.99);
        Product product3 = new Product("Desktop", "Desktop computer", "000002", 799.99);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
        assertNotEquals(product1, null);
        assertNotEquals(product1, "Laptop");
    }
}
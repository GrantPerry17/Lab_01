import org.junit.jupiter.api.Test;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest
{
    @Test
    public void testFullConstructor()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        assertEquals("Bilbo", person.getFirstName());
        assertEquals("Baggins", person.getLastName());
        assertEquals("000001", person.getID());
        assertEquals("Esq.", person.getTitle());
        assertEquals(1980, person.getYOB());
    }

    @Test
    public void testOverloadedConstructor()
    {
        Person person = new Person("000002", 2000);

        assertEquals("000002", person.getID());
        assertEquals(2000, person.getYOB());
    }

    @Test
    public void testSetFirstName()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        person.setFirstName("Frodo");

        assertEquals("Frodo", person.getFirstName());
    }

    @Test
    public void testSetLastName()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        person.setLastName("Took");

        assertEquals("Took", person.getLastName());
    }

    @Test
    public void testSetTitle()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        person.setTitle("Dr.");

        assertEquals("Dr.", person.getTitle());
    }

    @Test
    public void testSetYOB()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 2000);

        person.setYOB(1990);

        assertEquals(1990, person.getYOB());
    }

    @Test
    public void testSetYOBInvalid()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 2000);

        assertThrows(IllegalArgumentException.class, () -> person.setYOB(1939));
        assertThrows(IllegalArgumentException.class, () -> person.setYOB(2011));
    }

    @Test
    public void testFullName()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        assertEquals("Bilbo Baggins", person.fullName());
    }

    @Test
    public void testFormalName()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        assertEquals("Esq. Bilbo Baggins", person.formalName());
    }

    @Test
    public void testGetAge()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 2000);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        assertEquals(String.valueOf(currentYear - 2000), person.getAge());
    }

    @Test
    public void testGetAgeForYear()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 2000);

        assertEquals("26", person.getAge(2026));
    }

    @Test
    public void testToCSV()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        assertEquals("000001, Bilbo, Baggins, Esq., 1980", person.toCSV());
    }

    @Test
    public void testToJSON()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        assertEquals(
                "{\"ID\":\"000001\",\"firstName\":\"Bilbo\",\"lastName\":\"Baggins\",\"title\":\"Esq.\",\"YOB\":1980}",
                person.toJSON());
    }

    @Test
    public void testToXML()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        assertEquals(
                "<Person><ID>000001</ID><firstName>Bilbo</firstName><lastName>Baggins</lastName><title>Esq.</title><YOB>1980</YOB></Person>",
                person.toXML());
    }

    @Test
    public void testToString()
    {
        Person person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);

        assertEquals(
                "Person{firstName='Bilbo', lastName='Baggins', ID='000001', title='Esq.', YOB=1980}",
                person.toString());
    }

    @Test
    public void testEquals()
    {
        Person person1 = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);
        Person person2 = new Person("Bilbo", "Baggins", "000001", "Esq.", 1980);
        Person person3 = new Person("Frodo", "Baggins", "000002", "Esq.", 1968);

        assertEquals(person1, person2);
        assertNotEquals(person1, person3);
        assertNotEquals(person1, null);
        assertNotEquals(person1, "Bilbo");
    }
}
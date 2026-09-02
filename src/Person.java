import java.util.Calendar;
import java.util.Objects;

public class Person
{
    private String firstName;
    private String lastName;
    private final String ID;
    private String title;
    private int YOB;

    /**
     * Constructs a Person object with the specified information.
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param ID the person's ID
     * @param title the person's title
     * @param YOB the person's year of birth
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        setYOB(YOB);
    }

    /**
     * Constructs a Person object with empty name and title values.
     * @param ID the person's ID
     * @param YOB the person's year of birth
     */
    public Person(String ID, int YOB)
    {
        this("", "", ID, "", YOB);
    }

    /**
     * Gets the person's first name.
     * @return the person's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Gets the person's last name.
     * @return the person's last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Gets the person's ID.
     * @return the person's ID
     */
    public String getID()
    {
        return ID;
    }

    /**
     * Gets the person's title.
     * @return the person's title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the person's year of birth.
     * @return the person's year of birth
     */
    public int getYOB()
    {
        return YOB;
    }

    /**
     * Sets the person's first name.
     * @param firstName the new first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Sets the person's last name.
     * @param lastName the new last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Sets the person's title.
     * @param title the new title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Sets the person's year of birth.
     * @param YOB the new year of birth
     */
    public void setYOB(int YOB)
    {
        if(YOB >= 1940 && YOB <= 2010)
        {
            this.YOB = YOB;
        }
        else
        {
            throw new IllegalArgumentException("Year of birth must be between 1940 and 2010.");
        }
    }

    /**
     * Returns the person's full name.
     * @return the first name followed by the last name
     */
    public String fullName()
    {
        return firstName + " " + lastName;
    }

    /**
     * Returns the person's formal name.
     * @return the title followed by the person's full name
     */
    public String formalName()
    {
        return title + " " + fullName();
    }

    /**
     * Calculates the person's current age.
     * @return the person's current age as a String
     */
    public String getAge()
    {
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);

        return getAge(currentYear);
    }

    /**
     * Calculates the person's age for a specified year.
     * @param year the year for which to calculate the person's age
     * @return the person's age as a String
     */
    public String getAge(int year)
    {
        return String.valueOf(year - YOB);
    }

    /**
     * Returns the person as a comma-separated value record.
     * @return the person's data in CSV format
     */
    public String toCSV()
    {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    /**
     * Returns the person as a JSON formatted String.
     * @return the person's data in JSON format
     */
    public String toJSON()
    {
        return "{\"ID\":\"" + ID + "\",\"firstName\":\"" + firstName
                + "\",\"lastName\":\"" + lastName + "\",\"title\":\"" + title
                + "\",\"YOB\":" + YOB + "}";
    }

    /**
     * Returns the person as an XML formatted String.
     * @return the person's data in XML format
     */
    public String toXML()
    {
        return "<Person><ID>" + ID + "</ID><firstName>" + firstName
                + "</firstName><lastName>" + lastName + "</lastName><title>"
                + title + "</title><YOB>" + YOB + "</YOB></Person>";
    }

    /**
     * Returns a String representation of the Person.
     * @return a String containing the person's information
     */
    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    /**
     * Compares this Person with another object for equality.
     * @param obj the object to compare with this Person
     * @return true if the objects contain the same Person data, otherwise false
     */
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }

        if(!(obj instanceof Person))
        {
            return false;
        }

        Person other = (Person) obj;

        return YOB == other.YOB
                && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(ID, other.ID)
                && Objects.equals(title, other.title);
    }

    /**
     * Returns a hash code for this Person.
     * @return a hash code based on the person's fields
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName, ID, title, YOB);
    }
}
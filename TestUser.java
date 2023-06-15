import java.util.ArrayList;
import java.util.Date;

public class TestUser
{
    private String lastName;
    private String firstName;
    private String position;
    private String department;
    private Date dateHired;

    public TestUser(String lastName, String firstName, String position, String department, Date dateHired)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
        this.department = department;
        this.dateHired = dateHired;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public String toString()
    {
        return "\t" + lastName.toUpperCase() + "\t\t\t" + firstName.toUpperCase() + "\t\t\t\t" + position + "\t\t\t" + department + "\t\t" + dateHired;
    }
}

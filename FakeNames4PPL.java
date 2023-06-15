import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FakeNames4PPL
{
    private static void outputUserGroup(ArrayList<TestUser> users)
    {
        try
        {
            FileWriter fw = new FileWriter("testUsers.txt", false);
            PrintWriter outputFile = new PrintWriter(fw);

            outputFile.println("LAST NAME\t\t\tFIRST NAME\t\t\tPOSITION\t\tDEPARTMENT\t\tHIRE DATE");
            for (int index = 0; index < users.size(); index ++)
            {
                outputFile.println(users.get(index));
            }
            outputFile.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void generateCustomDate(List<Date> dates)
    {
        int m,d,y = 0;
        Date date;

        for (int month = 1; month < 13; month++)
        {
            m = month;

            for (int day = 1; day < 31; day++)
            {
                if (m == 2 && day > 28)
                {
                    day = 1;
                    m++;
                }
                d = day;

                for (int year = 2000; year < 2021; year++)
                {
                    y = year;
                    date = new Date(m,d,y);
                    dates.add(date);
                }
            }
        }
    }

    private static void generateFileData(String filename, List<String> list)
    {
        File f = new File(filename);
        try
        {
         Scanner inputFile = new Scanner(f);

         while (inputFile.hasNextLine())
            {
                String line = inputFile.nextLine();
                list.add(line);
            }

         inputFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<TestUser> users = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();
        List<String> position = new ArrayList<>();
        List<String> department = new ArrayList<>();
        List<Date> dates = new ArrayList<>();

        System.out.println("Enter the size of the fake user database: ");
        int size = keyboard.nextInt();

        System.out.println("Generating list...");

        generateFileData("boyNames.txt", first);
        generateFileData("girlNames.txt", first);
        generateFileData("surnames.txt", last);
        generateFileData("positions.txt", position);
        generateFileData("departments.txt", department);
        generateCustomDate(dates);

        Random r = new Random();


        System.out.println("Creating output file...");

        for (int index = 0; index < size; index++) {
//            list.add(new TestUser("Davis", "Jason", "Nurse", "Emergency Room", new Date(12, 14, 2017)));
            users.add(new TestUser(last.get(r.nextInt(last.size())), first.get(r.nextInt(first.size())),
                    position.get(r.nextInt(position.size())), department.get(r.nextInt(department.size())),
                    dates.get(r.nextInt(dates.size()))));
//            System.out.println(users.get(index));
        }
        outputUserGroup(users);

        System.out.println("Output file created with " + size + " entries.");
    }
}

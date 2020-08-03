//Main 
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String filename;
        double lat1, lon1;       //user entered latitude and longitude
        //ask user to enter filename
        System.out.print("Enter the filename: ");
        filename = sc.next();
        //load file
        List<Centres> CCentres = Load(filename);
        System.out.println("Number of records loaded: " + CCentres.size());
        //display menu
        System.out.println("1. Display All Records.");
        System.out.println("2. Find nearest Community Centre.");
        System.out.println("0. Quit");

        //Variables for menu
        boolean quit = false;
        int menuItem;

        //Switch between the different commands on the menu.
        do {
            System.out.print("Choose menu item: ");
            menuItem = sc.nextInt();
            switch (menuItem)
            {
                //Displaying all records
                case 1:
                    System.out.println("Displaying all the community centres: ");
                    for (Centres c: CCentres)
                    {
                        System.out.println(c);
                    }
                    break;

                //User can enter an address they want to find community centres near
                case 2:
                    System.out.print("Enter latitude of your address: ");
                    lat1 = sc.nextDouble();
                    System.out.print("Enter longitude of your address: ");
                    lon1 = sc.nextDouble();
                    //calculate list of nearest community centres
                    Distance nearest = new Distance(lat1, lon1, CCentres);
                    List<Centres> nearCentres = nearest.near(CCentres);
                    if (nearCentres.size() == 0)
                        System.out.println("There are NO Community Centres that are 5km or less to your location.");
                    else {
                        System.out.println("Community Centres that are 5km or less to your location are: ");
                        for (Centres i: nearCentres)
                        {
                            i.toString2();
                        }
                    }
                    break;

                case 0:
                    quit = true;
                    break;

                default:
            }
        }while(!quit);

    }
    //load the file
    private static List<Centres> Load(String filename)
    {
        String line = "";
        List<Centres> CCentres = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            while ((line = br.readLine())!=null)
            {
                String[] data = line.split(",");
                if (!line.startsWith("F"))
                {
                    Centres centre = createCentre(data);
                    CCentres.add(centre);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CCentres;
    }
    //create a record
    private static Centres createCentre(String[] data)
    {
        int FID = Integer.parseInt(data[0]);
        String address = data[1];
        String name = data[2];
        double X = Double.parseDouble(data[3]);
        double Y = Double.parseDouble(data[4]);

        return new Centres(FID, address, name, X, Y);
    }
}

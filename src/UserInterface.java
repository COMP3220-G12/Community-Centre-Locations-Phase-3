//Terminal text interface
//By the Greater pattern, this class is independent from the creation of its objects. It's instances are created by Main.
//It maintains high cohesion as its central purpose is data visualization in text mood.

import java.util.ArrayList;
import java.util.Scanner;
//This class polymorphically extends the abstract class visualizer 
class UserInterface extends Visualizer
{

    public UserInterface()
    {
        super(); //super is Visualizer
    }
    //implemantaion of the abstract method from Visualize
    public void displayViewer()
    {
        boolean done = false;
        currentRecord=0;
        do
        {
            displayMenu();
            System.out.print("Enter menu option: ");
            int selection;
            // Declare a scanner to scan user input.
            Scanner sc = new Scanner(System.in);
            selection = sc.nextInt();
            //switch between the different commands on the menu.
            switch(selection)
            {
                case 1:
                    currentRecord = 0;
                    displayRecord();
                    break;
                case 2:
                    currentRecord = (currentRecord==records.size()-1)?currentRecord:currentRecord+1;
                    displayRecord();
                    break;
                case 3:
                    currentRecord = (currentRecord==0)?currentRecord:currentRecord-1;
                    displayRecord();
                    break;
                case 4:
                    currentRecord = records.size()-1;
                    displayRecord();
                    break;
                case 5:
                    displayRecords();
                    break;
                case 6:
                    System.out.println("Records will be sorted by " + LABELS[PRIMARY_KEY_FIELD_INDEX]);
                    records.sort();
                    displayRecords();
                    break;
                case 7:
                    System.out.print("Enter latitude of your address: ");
                    double lat1 = sc.nextDouble();
                    System.out.print("Enter long of your address: ");
                    double lon1 = sc.nextDouble();
                    Distance nearest = new Distance(lat1, lon1, newRecordList);
                    ArrayList<Record> closest = nearest.near();
                    if (closest.size() == 0)
                        System.out.println("There are NO Community Centres that are 5km or less to your location.");
                    break;
                case 0:
                    done = true;
                    break;
                default:
                    System.out.println("Incorrect option entered. Try again!");
                    break;
            }
        }while(!done);
    }

    public void displayMenu()
    {
        System.out.println("1. Display first record.");
        System.out.println("2. Display next record.");
        System.out.println("3. Display previous record.");
        System.out.println("4. Display last record.");
        System.out.println("5. Display all records.");
        System.out.println("6. Display sorted records.");
        System.out.println("7. Find nearest community centre (straight line distance).");
        System.out.println("0. Exit");
    }

    public void displayRecord()
    {
        System.out.println(records.get(currentRecord));
    }

    public void displayRecords()
    {
        System.out.println(records);
    }



}

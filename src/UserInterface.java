import java.util.Scanner;
class UserInterface extends Visualizer
{

    public UserInterface()
    {
        super();
    }

    public void displayViewer()
    {
        boolean done = false;
        currentRecord=0;
        do
        {
            displayMenu();
            System.out.print("Enter menu option: ");
            int selection;
            Scanner sc = new Scanner(System.in);
            selection = sc.nextInt();
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
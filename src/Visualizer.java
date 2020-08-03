
abstract class Visualizer implements Template
{
    public Load records;
    public int currentRecord;

    public abstract void displayViewer();

    public Visualizer()
    {
        records = new Load();
        System.out.println("Number of loaded records: " + records.loadRecords());
    }

}
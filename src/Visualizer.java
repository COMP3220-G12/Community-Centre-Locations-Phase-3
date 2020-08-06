import java.util.ArrayList;

abstract class Visualizer implements Template
{
    public Load records;
    public int currentRecord;
    public ArrayList<Record> newRecordList;

    public abstract void displayViewer();

    public Visualizer()
    {
        records = new Load();
        newRecordList = records.loadRecords();
        System.out.println("Number of loaded records: " + newRecordList.size());
    }

}
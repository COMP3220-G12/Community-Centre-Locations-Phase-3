/** Visualizer an abstract class that enables us to have options to view the data
**  For now, we will just use the text terminal view only, but we can easily plug-in any other viewing mood in the future.
**  Using polymorphism this class helps in creating pluggable software component and handle alternatives based on types.
**  It also supports high cohesion, as all of it's elements are supporting the same purpose.
*/

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

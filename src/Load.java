
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Load implements Template
{
    public ArrayList<Record> recordList;

    /** default constructor */
    public Load()
    {
        recordList = new ArrayList<>();
    }

    public Record get(int n)
    {
        return recordList.get(n);
    }

    public int loadRecords()
    {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME)))
        {
            while ((line = br.readLine())!=null)
            {
                if (line.trim().length()==0) continue;	   //empty line
                if (line.startsWith(LABELS[0])) continue;  //column with labels
                recordList.add(new Record(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordList.size();
    }

    public void sort() // sort according to primary key defined in RecordTemplate
    {
        recordList.sort((Record r1, Record r2)->r1.getValue(PRIMARY_KEY_FIELD_INDEX).compareTo(r2.getValue(PRIMARY_KEY_FIELD_INDEX)));
    }

    public int size()
    {
        return recordList.size();
    }

    public String toString()
    {
        String s="";
        for (Record r : recordList)
            s+=r+"\n";
        return s;
    }

}

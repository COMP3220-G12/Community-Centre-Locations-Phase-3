import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Iterator;

public class Record implements Template
{
    public HashMap<Integer, Field> recordMap;
    public Record (String line)
    {
        recordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(line, DELIMITER);
        for (int i=0; i<NUMBER_OF_FIELDS; i++)
        {
            recordMap.put(i, new Field(TYPES[i], LABELS[i], st.nextToken()));
        }
    }
    public boolean setFieldValue(int fieldIndex, String newValue)
    {
        if (fieldIndex < 0 || fieldIndex > NUMBER_OF_FIELDS) return false;

        Field newField = new Field(recordMap.get(fieldIndex).type, recordMap.get(fieldIndex).label, newValue);

        recordMap.replace(fieldIndex, newField);

        return true;
    }
    public String toString()
    {
        String line="";
        Iterator<Integer> keySetIterator = recordMap.keySet().iterator();
        Integer key;
        while(keySetIterator.hasNext())
        {
            key = keySetIterator.next();
            if (key == 0) line+=recordMap.get(key);
            else line+=DELIMITER+recordMap.get(key);
        }
        return line;
    }

    public String getType(int fieldIndex)
    {
        return recordMap.get(fieldIndex).type;
    }
    public String getLabel(int fieldIndex)
    {
        return recordMap.get(fieldIndex).label;
    }
    public String getValue(int fieldIndex)
    {
        return recordMap.get(fieldIndex).value;
    }
    class Field
    {
        public String type;
        public String label;
        public String value;

        public Field(String type, String label, String value)
        {
            this.type = type;
            this.label = label;
            this.value = value;
        }
        public String toString()
        {
            return " " + label + ": " + value;
        }
    }
}

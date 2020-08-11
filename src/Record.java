/** Record is a class that stores individual records using HashMaps to store Keys and records then map them
 ** This way we will have an array of records to be accessed by mapping to the keys.
 **It maintains High cohesion as it has all the elements related to records data structure, record field defining, getting and setting record attributes, etc.
*/

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Iterator;

public class Record implements Template
{
  
  // inner class to define a field (the building block of a record)
   class Field
    {
        //filed attributes
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
  
    // to create a Hashmap with Keys and arry of record
    public HashMap<Integer, Field> recordMap;
    // create a blank record, then each record will have it's own fields
    // each line is a record and fields are seperated by ","
    public Record (String line)
    {
        recordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(line, DELIMITER);
        for (int i=0; i<NUMBER_OF_FIELDS; i++)
        {
            recordMap.put(i, new Field(TYPES[i], LABELS[i], st.nextToken()));
        }
    }
    //set method to set the fields values
    public boolean setFieldValue(int fieldIndex, String newValue)
    {
        if (fieldIndex < 0 || fieldIndex > NUMBER_OF_FIELDS) return false;

        Field newField = new Field(recordMap.get(fieldIndex).type, recordMap.get(fieldIndex).label, newValue);

        recordMap.replace(fieldIndex, newField);

        return true;
    }
  
    //get methods
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
    public double getX()
    {
        return Double.parseDouble(recordMap.get(3).value);
    }
    public double getY()
    {
        return Double.parseDouble(recordMap.get(4).value);
    }
    
     //override toString
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

}

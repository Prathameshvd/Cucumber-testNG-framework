package supportingClasses;

import java.util.HashMap;
import java.util.Map;

public class DummyDatabase {

    //Creating static so that all object will be able to access same data
    static Map<String,String> DummyDatabase = new HashMap<>();

    public DummyDatabase()
    {
        DummyDatabase = new HashMap<>();
    }

    public void addValueInDummyDB(String Key, String Value)
    {
        DummyDatabase.put(Key, Value);
    }

    public String getValueInDummyDB(String Key)
    {
        return DummyDatabase.get(Key);
    }
}
package supportingClasses;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

//To load ConfigFileData from the Config YAML file
public class ConfigLoader {

    FileInputStream inputStream;
    {
        try {
            inputStream = new FileInputStream(new File("Config/Config.yml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //To get data from the Config.yml
    public Map<String, String> configReader(){
    Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }
}

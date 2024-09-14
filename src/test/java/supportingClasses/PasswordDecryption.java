package supportingClasses;

import src.PasswordMethods;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class PasswordDecryption {

    //To load ConfigFileData from the Config YAML file
    public ConfigLoader configLoader = new ConfigLoader();
    Map<String, String> ConfigFileData = configLoader.configReader();

    PasswordMethods passwordMethods = new PasswordMethods();
    String AppDecryptedPassword;
    String DatabaseDecryptedPassword;

    //To get AppDecryptedPassword
    public String getAppDecryptedPassword() {
        try {
            AppDecryptedPassword = passwordMethods.getDecryptedPassword(ConfigFileData.get("Password"), System.getProperty("key"));
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException |
                 InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        return AppDecryptedPassword;
    }

    //To get DatabaseDecryptedPassword
    public String getDatabaseDecryptedPassword() {
        try {
            DatabaseDecryptedPassword = passwordMethods.getDecryptedPassword(ConfigFileData.get("DBPassword"), System.getProperty("key"));
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException |
                 InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        return DatabaseDecryptedPassword;
    }
}

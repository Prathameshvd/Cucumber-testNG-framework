package supportingClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public Logger logger = LogManager.getLogger(this.getClass());
    String AppDecryptedPassword=null;
    String DatabaseDecryptedPassword=null;

    //To get AppDecryptedPassword
    public String getAppDecryptedPassword() {
        try {
            AppDecryptedPassword = passwordMethods.getDecryptedPassword(ConfigFileData.get("Password"), System.getProperty("key"));
            if (AppDecryptedPassword==null)
                logger.info("AppDecryptedPassword value is null");
            else
                logger.info("getAppDecryptedPassword() - Successful");
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
            if (DatabaseDecryptedPassword==null)
                logger.info("DatabaseDecryptedPassword value is null");
            else
                logger.info("DatabaseDecryptedPassword() - Successful");
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException |
                 InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        return DatabaseDecryptedPassword;
    }
}

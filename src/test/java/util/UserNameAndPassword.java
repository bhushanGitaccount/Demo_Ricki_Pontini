package util;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/***
 * @author Bhushan more
 */
public class UserNameAndPassword {
    private Properties properties;
//    private final String propertyFilePath = "D:\\Frameworks\\Neosoft frameworks\\Demo_Ricki\\src\\test\\resources\\Credentials.properties";
    private final String propertyFilePath = System.getProperty("user.dir") + "/PropertiesFile/Allcredentials.properties";

    public UserNameAndPassword() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    /***
     *
     * @return
     */
    public String getBBUserNameDEV() {
        String BBUserNameDEV = properties.getProperty("BBUserNameDEV");
        if (BBUserNameDEV != null) return BBUserNameDEV;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public Map<String, String> userPWD() {
        Map<String, String> usernamepassword = new HashMap<String, String>();
        usernamepassword.put("Username",properties.getProperty("BBUserNameDEV"));
        usernamepassword.put("Password",properties.getProperty("BBPassDev"));
        if (usernamepassword != null) return usernamepassword;
        else throw new RuntimeException("Username and password not specified in the Configuration.properties file.");

    }
    public String getBBPasswordDev() {
        String BBPasswordDev = properties.getProperty("BBPassDev");
        if (BBPasswordDev != null) return BBPasswordDev;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getBBUserNameUAT() {
        String BBUserNameUAT = properties.getProperty("BBUserNameDEV");
        if (BBUserNameUAT != null) return BBUserNameUAT;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getBBPasswordUAT() {
        String BBPassUAT = properties.getProperty("BBPassUAT");
        if (BBPassUAT != null) return BBPassUAT;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }


}

package supportingClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseMethods {
    public Connection con;
    public ConfigLoader configLoader = new ConfigLoader();

    //To store Config.yml file data into the map
    Map<String, String> ConfigFileData = configLoader.configReader();

    //To Db Connection
    public void createDbConnection() {
        try {
            con= DriverManager.getConnection(ConfigFileData.get("DBurl"), ConfigFileData.get("DBUserName"), ConfigFileData.get("DBPassword"));
            String temp = con==null ? "JDBC Connection unsuccessful !" : "JDBC Connection Successfully !";
            System.out.println(temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //To close Db Connection
    public void closeDbConnection() {
        try {
            con.close();
            System.out.println("JDBC Connection Closed Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //To save data into Database
    public void saveRecord(String FirstName, String LastName, String Email, int Age, double Salary, String Department) {
        createDbConnection();
        try {
            PreparedStatement preparedStatement4 = con.prepareStatement("Insert into demoQA (First_Name, Last_Name, Email, Age, Salary, Department) Values (?,?,?,?,?,?)");
            preparedStatement4.setString(1, FirstName);
            preparedStatement4.setString(2, LastName);
            preparedStatement4.setString(3, Email);
            preparedStatement4.setInt(4, Age);
            preparedStatement4.setDouble(5, Salary);
            preparedStatement4.setString(6, Department);
            preparedStatement4.execute();
            System.out.println("WebTable records details stored successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeDbConnection();
    }

}

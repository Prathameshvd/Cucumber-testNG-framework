package supportingClasses;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseMethods {
    public Connection con;
    public ConfigLoader configLoader = new ConfigLoader();
    public DummyDatabase dummyDatabase = new DummyDatabase();
    public PasswordDecryption passwordDecryption = new PasswordDecryption();

    //To store Config.yml file data into the map
    Map<String, String> ConfigFileData = configLoader.configReader();

    //To Db Connection
    public void createDbConnection() {
        try {
            con= DriverManager.getConnection(ConfigFileData.get("DBurl"), ConfigFileData.get("DBUserName"), passwordDecryption.getDatabaseDecryptedPassword());
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
    public void saveRecordIntoDatabase(String FirstName, String LastName, String Email, int Age, double Salary, String Department) {
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

    //To get Data from Database
    public ResultSet getWebTableRecordDataFromDatabase() {
        createDbConnection();
        try {
            PreparedStatement preparedStatement= con.prepareStatement("Select * from demoQA where Email=?");
            preparedStatement.setString(1,dummyDatabase.getValueInDummyDB("Email"));
            ResultSet rs= preparedStatement.executeQuery();
            rs.next();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //To create excel report
    public void storeDataIntoExcelFile(ResultSet rs) {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("WebTableRecord_" + dummyDatabase.getValueInDummyDB("Email"));
        try {
            ResultSetMetaData resultSetMetaData= rs.getMetaData();
            int ColumnCount = resultSetMetaData.getColumnCount();
            List<Object> Header=new ArrayList<>();
            for(int i=1; i<=ColumnCount; i++)
            {
                Header.add(resultSetMetaData.getColumnName(i));
            }
            XSSFRow HeaderRow = sheet.createRow(0);
            for(int i=0; i<ColumnCount;i++) {
                XSSFCell cell = HeaderRow.createCell(i);
                cell.setCellValue(String.valueOf(Header.get(i)));
            }
            XSSFRow row;
            XSSFCell cell;
            int RowCount=1;
            do {
                row= sheet.createRow(RowCount++);
                int CellCount=1;
                for(int i=0; i<ColumnCount;i++) {
                    cell = row.createCell(i);
                    System.out.print("  " + rs.getObject(CellCount));
                    cell.setCellValue(String.valueOf(rs.getObject(CellCount)));
                    CellCount++;
                }
            }while(rs.next());
            FileOutputStream fileOutputStream=new FileOutputStream(new File("D:/LightWaitSW/IntelliJ IDEA/IdeaProjects/CucumberWithTestNG/Evidences/DB_Export_ExcelFile/WebTable.xlsx"));
            workbook.write(fileOutputStream);
            workbook.close();
            System.out.println();
            System.out.println("Data stored into excel file successfully");
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            closeDbConnection();
        }
    }
}
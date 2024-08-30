package supportingClasses;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ScreenshotAndCreateWordFile {
    DummyDatabase dummyDatabase = new DummyDatabase();
    static DriverSetup driverSetup = new DriverSetup();
    public static WebDriver driver;
    static XWPFDocument document;
    static XWPFRun run;
    static FileOutputStream fileOutputStream;
    String GeneralPath="D:/LightWaitSW/IntelliJ IDEA/IdeaProjects/CucumberWithTestNG/Evidences/ScreenShots_WordFile/";

    @Before
    public void openDocumentAndIOStreams() {
        System.out.println("====================Before====================");
        driver = driverSetup.driverSetup();
        document = new XWPFDocument();
        run = document.createParagraph().createRun();
        System.out.println(run);
        try {
            fileOutputStream =new FileOutputStream(GeneralPath + "WebRecord.docx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterStep
    public void takeScreenShots() throws IOException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        StringBuilder FullPathOfFile = new StringBuilder().append(GeneralPath).append("ScreenShots/").append(dummyDatabase.getValueInDummyDB("Email")).append(dtf.format(now)).append(".png");
        System.out.println("Full name of the file is :- " + FullPathOfFile);
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File TargetFile = new File(String.valueOf(FullPathOfFile));
            SourceFile.renameTo(TargetFile);

            InputStream inputStream = new FileInputStream(String.valueOf(FullPathOfFile));
            run.addBreak();
            run.addPicture(inputStream, XWPFDocument.PICTURE_TYPE_PNG, String.valueOf(FullPathOfFile), Units.toEMU(400), Units.toEMU(400));
            inputStream.close();
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void closeDocumentAndIOStreams() throws IOException {
        System.out.println("====================After====================");
        document.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        document.close();
        driver.quit();
    }
}
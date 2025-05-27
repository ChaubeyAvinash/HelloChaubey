package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "E:/JavaPro/src/test/resources/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        String url = "https://www.flipkart.com/";
        List<String[]> data = readCSV("C:/Users/DELL/OneDrive/Desktop/Book2.csv");
        for (String[] row : data) {
            String username = row[0];
            String password = row[1];
            driver.get(url);
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            // Find and click the login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

                    }

        // Close the browser after the operations
        driver.quit();
    }

    // Method to read data from a CSV file
    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        
        // Read the header line (if needed)
        reader.readLine(); // Skip the header row (if present)

        // Read each line from the CSV
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(","); // Split by comma (for CSV format)
            data.add(values);
        }

        // Close the reader
        reader.close();

        return data;
    }
}


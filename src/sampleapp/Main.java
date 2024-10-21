package sampleapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String[] youtubeLinks = {
                "" // INSERT YOUTUBE LINKS OF MUSIC VIDEOS YOU WANT TO DOWNLOAD
        };

        driver.get("https://x.ytmp3s.nu/LTRg/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        for(String link : youtubeLinks) {
            try {

                WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("url")));
                inputField.clear();
                inputField.sendKeys(link);

                WebElement convertButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=\"submit\"]")));
                convertButton.click();

                WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[2]/a[1]")));
                downloadButton.click();

                Thread.sleep(1000);

                WebElement convertNextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[2]/a[2]")));
                convertNextButton.click();

            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}

package selenium_webdriver;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import java.awt.*;
import java.util.Scanner;

public class TestPHPTravelsSignUp {
    public static WebDriver driver;


    @BeforeAll
    public static void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Enter Full Name")
    public void testEnterFullName() {
        driver.get("https://phptravels.org/register.php");
        // Enter the first name
        WebElement firstNameField = driver.findElement(By.id("inputFirstName"));
        firstNameField.sendKeys("Test_001");
        // Verify the first name input is correct
        Assert.assertEquals("Test_001", firstNameField.getAttribute("value"));
        // Enter the last name
        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.sendKeys("Testing");
    }

    @Test
    @DisplayName("Enter the Email")
    public void testEnterEmail() {
        driver.get("https://phptravels.org/register.php");
        // Enter the email address
        WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        emailAddressField.sendKeys("test_001@test.com");
    }

    @Test
    @DisplayName("Enter the Phone Number")
    public void testEnterPhone() {
        driver.get("https://phptravels.org/register.php");
        // Choose phone number code
        WebElement phoneCodeBtn = driver.findElement(By.className("iti-arrow"));
        phoneCodeBtn.click();

        WebElement countriesWindow = driver.findElement(By.xpath("//ul[@class='country-list']"));
        List<WebElement> countriesCodeList = countriesWindow.findElements(By.tagName("li"));
        for (WebElement li : countriesCodeList) {
            if (li.getText().contains("States")) { li.click(); }
        }
        // Enter the phone number
        WebElement phoneNumberField = driver.findElement(By.cssSelector("input#inputPhone"));
        phoneNumberField.sendKeys("8440002222" + Keys.TAB);
    }

    @Test
    @DisplayName("Press \"Register\" button")
    public void testPressRegisterButton() {
        driver.get("https://phptravels.org/register.php");
        // Register user (although not all mandatory fields are filled in)
        WebElement registerBtn = driver.findElement(By.xpath("//input[@class='btn btn-large btn-primary btn-recaptcha']"));
        registerBtn.click();
    }

    /** Repeat all Tests in one */
    @Test
    @DisplayName("Enter Full \"Personal Information\" section")
    public void testEnterPersonalInfo() {
        driver.get("https://phptravels.org/register.php");
        // Enter the first name
        WebElement firstNameField = driver.findElement(By.id("inputFirstName"));
        firstNameField.sendKeys("Test_001");
        // Verify the first name input is correct
        Assert.assertEquals("Test_001", firstNameField.getAttribute("value"));
        // Enter the last name
        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.sendKeys("Testing");
        // Enter the email address
        WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        emailAddressField.sendKeys("test_001@test.com");
        // Choose phone number code
        WebElement phoneCodeBtn = driver.findElement(By.className("iti-arrow"));
        phoneCodeBtn.click();

        WebElement countriesWindow = driver.findElement(By.xpath("//ul[@class='country-list']"));
        List<WebElement> countriesCodeList = countriesWindow.findElements(By.tagName("li"));
        for (WebElement li : countriesCodeList) {
            if (li.getText().contains("States")) { li.click(); }
        }
        //countriesCodeList.get(1).click(); // also an option

        // Enter the phone number
        WebElement phoneNumberField = driver.findElement(By.cssSelector("input#inputPhone"));
        phoneNumberField.sendKeys("8440002222" + Keys.TAB);

        // Register user (although not all mandatory fields are filled in)
        WebElement registerBtn = driver.findElement(By.xpath("//input[@class='btn btn-large btn-primary btn-recaptcha']"));
        registerBtn.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}

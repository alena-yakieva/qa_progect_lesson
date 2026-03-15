package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NameSeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    void nameTest() {
        driver.get("https://mts.by/");

        
        try {
            By acceptButtonLocator = By.xpath(
                ("//button[contains(text(), 'Принять')]"));

            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptButtonLocator));
            acceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptButton));
            System.out.println("Cookie banner accepted");
        } catch (Exception e) {
        }

        By blockLocator = By.xpath("//h2[contains(., 'Онлайн пополнение без комиссии')]");
        WebElement blockElement = wait.until(d -> d.findElement(blockLocator));

        assertTrue(blockElement.isDisplayed(), "Блок 'Онлайн пополнение без комиссии' не отображается");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



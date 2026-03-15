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

public class LogoSeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    void testLogo() {
        driver.get("https://mts.by/");

        try {
            By acceptButtonLocator = By.xpath(
                ("//button[contains(text(), 'Принять')]"));

            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptButtonLocator));
            acceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptButton));
        } catch (Exception e) {
        }

        String[] paymentLogos = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};

        for (String logoName : paymentLogos) {
            String xpathExpression = String.format(
            
    "//img[contains(@alt, '%s')]", logoName);

By logoLocator = By.xpath(xpathExpression);

            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocator));
            assertTrue(logo.isDisplayed(), "Логотип '" + logoName + "' не отображается на странице");
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

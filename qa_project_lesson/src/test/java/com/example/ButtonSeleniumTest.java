package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonSeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;

     @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
void testButton() {
        driver.get("https://mts.by/");

        try {
            By acceptButtonLocator = By.xpath(
                ("//button[contains(text(), 'Принять')]"));

            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptButtonLocator));
            acceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptButton));
            
        } catch (Exception e) {
        }

        try {
            By servicesButton = By.xpath("//span[contains(text(), 'Услуги связи')]");
            WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(servicesButton));
            Button.click();
        } catch (Exception e) {
            throw e;
        }
        try {
            By phoneInput = By.xpath("//input[@id='connection-phone']");
            WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(phoneInput));
            phoneField.clear();
            phoneField.sendKeys("297777777");
        } catch (Exception e) {
            throw e;
        }

        try {
            By sumInput = By.xpath("//input[@id='connection-sum']");
            WebElement sumField = wait.until(ExpectedConditions.elementToBeClickable(sumInput));
            sumField.clear();
            sumField.sendKeys("50");
        } catch (Exception e) {
            throw e;
        }

        try {
            By continueButtonLocator = By.xpath("//button[contains(text(), 'Продолжить')]");
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
            continueButton.click();
           
        } catch (Exception e) {
            throw e;
        }

        try {
           By paymentPopupLocator = By.xpath("//div[contains(@class, 'payment-widget-app')]");

     WebElement paymentPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPopupLocator));
            assertTrue(paymentPopup.isDisplayed(), "Всплывающее окно оплаты не появилось после нажатия кнопки 'Продолжить'");
        
            
         } catch (Exception e) {
            throw e;
        }
    }
    
     @AfterEach
         void tearDown() {
            if (driver != null) {
                 driver.quit();
        }
    }

}


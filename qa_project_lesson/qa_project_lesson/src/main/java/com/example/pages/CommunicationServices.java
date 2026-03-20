package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CommunicationServices extends MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By PHONE_INPUT = MainPage.PHONE_INPUT;
    private static final By SUM_INPUT = MainPage.SUM_INPUT;
    private static final By EMAIL_INPUT = MainPage.EMAIL_INPUT;
    

    public CommunicationServices(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void phone(String phoneValue) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(PHONE_INPUT));
        phoneField.clear();
        phoneField.sendKeys(phoneValue);
    }

    public void sum(String sumValue) {
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(SUM_INPUT));
         wait.until(ExpectedConditions.elementToBeClickable(SUM_INPUT));
        sumField.clear();
        sumField.sendKeys(sumValue);
    }

    public void email(String emailValue) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(EMAIL_INPUT));
        emailField.clear();
        emailField.sendKeys(emailValue);
    }

    public String getPhonePlaceholder() {
        return getPlaceholder(PHONE_INPUT);
    }

    public String getSumPlaceholder() {
        return getPlaceholder(SUM_INPUT);
    }

    public String getEmailPlaceholder() {
        return getPlaceholder(EMAIL_INPUT);
    }

    public boolean isPhoneFieldVisible() {
        return isElementVisible(PHONE_INPUT, 5);
    }

    public boolean isSumFieldVisible() {
        return isElementVisible(SUM_INPUT, 5);
    }

    public boolean isEmailFieldVisible() {
        return isElementVisible(EMAIL_INPUT, 5);
    }

        public boolean isElementVisible(By locator, int timeoutSeconds) {
    try {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        WebElement element = localWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.isDisplayed();
    } catch (org.openqa.selenium.TimeoutException e) {
        return false;
    }
}
private String getPlaceholder(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String placeholder = element.getAttribute("placeholder");
            return placeholder != null ? placeholder : "";
        } catch (Exception e) {
            return "";
        }
    }
}


    




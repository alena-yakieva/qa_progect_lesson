package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Debt extends MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By DEBT_CHECK_INPUT = MainPage.DEBT_CHECK_INPUT;
    private static final By DEBT_SUM_INPUT = MainPage.DEBT_SUM_INPUT;
    private static final By DEBT_EMAIL_INPUT = MainPage.DEBT_EMAIL_INPUT;

    public Debt(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
         
    public void debtCheck(String debtCheckValue) {
        WebElement debtCheckField = wait.until(ExpectedConditions.visibilityOfElementLocated(DEBT_CHECK_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(DEBT_CHECK_INPUT));
        debtCheckField.clear();
        debtCheckField.sendKeys(debtCheckValue);
    }

    public void debtSum(String debtSumValue) {
        WebElement debtSumField = wait.until(ExpectedConditions.visibilityOfElementLocated(DEBT_SUM_INPUT));
         wait.until(ExpectedConditions.elementToBeClickable(DEBT_SUM_INPUT));
        debtSumField.clear();
        debtSumField.sendKeys(debtSumValue);
    }

    public void debtEmail(String debtEmailValue) {
        WebElement debtEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(DEBT_EMAIL_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(DEBT_EMAIL_INPUT));
        debtEmailField.clear();
        debtEmailField.sendKeys(debtEmailValue);
    }

    public String getDebtCheckPlaceholder() {
        return getPlaceholder(DEBT_CHECK_INPUT);
    }

    public String getDebtSumPlaceholder() {
        return getPlaceholder(DEBT_SUM_INPUT);
    }

    public String getDebtEmailPlaceholder() {
        return getPlaceholder(DEBT_EMAIL_INPUT);
    }

    public boolean isDebtCheckFieldVisible() {
        return isElementVisible(DEBT_CHECK_INPUT, 5);
    }

    public boolean isDebtSumFieldVisible() {
        return isElementVisible(DEBT_SUM_INPUT, 5);
    }

    public boolean isDebtEmailFieldVisible() {
        return isElementVisible(DEBT_EMAIL_INPUT, 5);
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


    
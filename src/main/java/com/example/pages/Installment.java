package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Installment extends MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By INSTALLMENT_CHECK_INPUT = MainPage.INSTALLMENT_CHECK_INPUT;
    private static final By INSTALLMENT_SUM_INPUT = MainPage.INSTALLMENT_SUM_INPUT;
    private static final By INSTALLMENT_EMAIL_INPUT = MainPage.INSTALLMENT_EMAIL_INPUT;

public Installment(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void InstallmentCheck(String installmentCheckValue) {
        WebElement installmentCheckField = wait.until(ExpectedConditions.visibilityOfElementLocated(INSTALLMENT_CHECK_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(INSTALLMENT_CHECK_INPUT));
        installmentCheckField.clear();
        installmentCheckField.sendKeys(installmentCheckValue);
    }

    public void InstallmentSum(String installmentSumValue) {
        WebElement installmentSumField = wait.until(ExpectedConditions.visibilityOfElementLocated(INSTALLMENT_SUM_INPUT));
         wait.until(ExpectedConditions.elementToBeClickable(INSTALLMENT_SUM_INPUT));
        installmentSumField.clear();
        installmentSumField.sendKeys(installmentSumValue);
    }

    public void InstallmentEmail(String installmentEmailValue) {
        WebElement InstallmentEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(INSTALLMENT_EMAIL_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(INSTALLMENT_EMAIL_INPUT));
        InstallmentEmailField.clear();
        InstallmentEmailField.sendKeys(installmentEmailValue);
    }

     public String getInstallmentCheckPlaceholder() {
        return getPlaceholder(INSTALLMENT_CHECK_INPUT);
    }

    public String getInstallmentSumPlaceholder() {
        return getPlaceholder(INSTALLMENT_SUM_INPUT);
    }

    public String getInstallmentEmailPlaceholder() {
        return getPlaceholder(INSTALLMENT_EMAIL_INPUT);
    }

    public boolean isInstallmentCheckFieldVisible() {
        return isElementVisible(INSTALLMENT_CHECK_INPUT, 5);
    }

    public boolean isInstallmentSumFieldVisible() {
        return isElementVisible(INSTALLMENT_SUM_INPUT, 5);
    }

    public boolean isInstallmentEmailFieldVisible() {
        return isElementVisible(INSTALLMENT_EMAIL_INPUT, 5);
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
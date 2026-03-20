package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomeInternet extends MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By HOME_INTERNET_PHONE_INPUT = MainPage.HOME_INTERNET_PHONE_INPUT;
    private static final By HOME_INTERNET_SUM_INPUT = MainPage.HOME_INTERNET_SUM_INPUT;
    private static final By HOME_INTERNET_EMAIL_INPUT = MainPage.HOME_INTERNET_EMAIL_INPUT;

    public HomeInternet(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void homeInternetPhone(String HomeInternetPhoneValue) {
        WebElement homeInternetPhoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_INTERNET_PHONE_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(HOME_INTERNET_PHONE_INPUT));
        homeInternetPhoneField.clear();
        homeInternetPhoneField.sendKeys(HomeInternetPhoneValue);
    }

    public void homeInternetSum(String HomeInternetSumValue) {
        WebElement homeInternetSumField = wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_INTERNET_SUM_INPUT));
         wait.until(ExpectedConditions.elementToBeClickable(HOME_INTERNET_SUM_INPUT));
        homeInternetSumField.clear();
        homeInternetSumField.sendKeys(HomeInternetSumValue);
    }

    public void homeInternetEmail(String HomeInternetEmailValue) {
        WebElement homeInternetEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_INTERNET_EMAIL_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(HOME_INTERNET_EMAIL_INPUT));
        homeInternetEmailField.clear();
        homeInternetEmailField.sendKeys(HomeInternetEmailValue);
    }


     public String getHomeInternetPhonePlaceholder() {
        return getPlaceholder(HOME_INTERNET_PHONE_INPUT);
    }

    public String getHomeInternetSumPlaceholder() {
        return getPlaceholder(HOME_INTERNET_SUM_INPUT);
    }

    public String getHomeInternetEmailPlaceholder() {
        return getPlaceholder(HOME_INTERNET_EMAIL_INPUT);
    }

    public boolean isHomeInternetPhoneFieldVisible() {
        return isElementVisible(HOME_INTERNET_PHONE_INPUT, 5);
    }

    public boolean isHomeInternetSumFieldVisible() {
        return isElementVisible(HOME_INTERNET_SUM_INPUT, 5);
    }

    public boolean isHomeInternetEmailFieldVisible() {
        return isElementVisible(HOME_INTERNET_EMAIL_INPUT, 5);
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


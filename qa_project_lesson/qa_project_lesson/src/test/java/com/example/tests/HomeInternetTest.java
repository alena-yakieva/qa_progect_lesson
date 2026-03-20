package com.example.tests;

import com.example.pages.HomeInternet;
import com.example.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class HomeInternetTest {
    private WebDriver driver;
    private MainPage mainPage;
    private HomeInternet homeInternet;

    @BeforeEach
     public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        homeInternet = new HomeInternet(driver);
        driver.get("https://mts.by/");
        mainPage.closeButtonLocator();
}

@Test
    public void checkPlaceholdersInHomeInternetSection() {
    homeInternet = mainPage.goToHomeInternet(); 
     
    assertTrue(homeInternet.isHomeInternetPhoneFieldVisible(), "Поле ввода номера счета не видно");
    assertTrue(homeInternet.isHomeInternetSumFieldVisible(), "Поле ввода суммы не видно");
    assertTrue(homeInternet.isHomeInternetEmailFieldVisible(), "Поле ввода e-mail не видно");

    assertEquals(homeInternet.getHomeInternetPhonePlaceholder(), "Номер абонента", "Плейсхолдер телефона не соответствует ожидаемому");
    assertEquals(homeInternet.getHomeInternetSumPlaceholder(), "Сумма", "Плейсхолдер суммы не соответствует ожидаемому");
    assertEquals(homeInternet.getHomeInternetEmailPlaceholder(), "E-mail для отправки чека", "Плейсхолдер e-mail не соответствует ожидаемому");

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

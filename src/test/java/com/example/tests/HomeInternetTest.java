package com.example.tests;

import com.example.pages.HomeInternet;
import com.example.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.*;

@Epic("UI Testing")
@Feature("Home Internet Page")

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
@Story("Проверка надписей в полях в разделе Домашний интернет")
@Severity(SeverityLevel.CRITICAL)
@Description("Проверяет видимость полей и корректность надписей")
    public void checkPlaceholdersInHomeInternetSection() {
    homeInternet = mainPage.goToHomeInternet();
     homeInternetPhoneField();
     homeInternetSumField();
     homeInternetEmailField();
    }

@Step("Проверка поля номер абонента")
private void homeInternetPhoneField() {    
    assertTrue(homeInternet.isHomeInternetPhoneFieldVisible(), "Поле ввода номера абонента не видно");
    assertEquals(homeInternet.getHomeInternetPhonePlaceholder(), "Номер абонента", "Плейсхолдер телефона не соответствует ожидаемому");
}
@Step("Проверка поля сумма")
private void homeInternetSumField() {    
    assertTrue(homeInternet.isHomeInternetSumFieldVisible(), "Поле ввода суммы не видно");
    assertEquals(homeInternet.getHomeInternetSumPlaceholder(), "Сумма", "Плейсхолдер суммы не соответствует ожидаемому");
}
@Step("Проверка поля e-mail")
private void homeInternetEmailField() {     
    assertTrue(homeInternet.isHomeInternetEmailFieldVisible(), "Поле ввода e-mail не видно");   
    assertEquals(homeInternet.getHomeInternetEmailPlaceholder(), "E-mail для отправки чека", "Плейсхолдер e-mail не соответствует ожидаемому");
}

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

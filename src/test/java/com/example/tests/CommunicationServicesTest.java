package com.example.tests;

import com.example.pages.CommunicationServices;
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
@Feature("Communication Services Page")
public class CommunicationServicesTest {
    private WebDriver driver;
    private MainPage mainPage;
    private CommunicationServices communicationServices;
    

    @BeforeEach
     public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        communicationServices = new CommunicationServices(driver);
        driver.get("https://mts.by/");
        mainPage.closeButtonLocator();
    }

    @Test
    @Story("Проверка надписей в полях в разделе Услуги связи")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяет видимость полей и корректность надписей")
    
    public void checkPlaceholdersInCommunicationServicesSection() { 
    communicationServices = mainPage.goToCommunicationServices(); 
    checkPhoneField();
    checkSumField();
    checkEmailField();
    }

    @Step("Проверка поля телефона") 
    private void checkPhoneField() {   
    assertTrue(communicationServices.isPhoneFieldVisible(), "Поле ввода номера телефона не видно");
    assertEquals(communicationServices.getPhonePlaceholder(), "Номер телефона", "Плейсхолдер телефона не соответствует ожидаемому");
    }
    @Step("Проверка поля суммы")
    private void checkSumField() {
    assertTrue(communicationServices.isSumFieldVisible(), "Поле ввода суммы не видно");
    assertEquals(communicationServices.getSumPlaceholder(), "Сумма", "Плейсхолдер суммы не соответствует ожидаемому");
    }
    @Step("Проверка поля e‑mail")
    private void checkEmailField() {
    assertTrue(communicationServices.isEmailFieldVisible(), "Поле ввода e-mail не видно");   
    assertEquals(communicationServices.getEmailPlaceholder(), "E-mail для отправки чека", "Плейсхолдер e-mail не соответствует ожидаемому");
    }
    
    @AfterEach
        public void tearDown() {
            if (driver != null) {
                driver.quit();
        }
    }
}






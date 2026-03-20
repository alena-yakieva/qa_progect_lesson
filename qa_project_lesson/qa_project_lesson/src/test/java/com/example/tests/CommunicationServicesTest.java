package com.example.tests;

import com.example.pages.CommunicationServices;
import com.example.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

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
    public void checkPlaceholdersInCommunicationServicesSection() { 
    communicationServices = mainPage.goToCommunicationServices(); 
     
    assertTrue(communicationServices.isPhoneFieldVisible(), "Поле ввода номера телефона не видно");
    assertTrue(communicationServices.isSumFieldVisible(), "Поле ввода суммы не видно");
    assertTrue(communicationServices.isEmailFieldVisible(), "Поле ввода e-mail не видно");

    assertEquals(communicationServices.getPhonePlaceholder(), "Номер телефона", "Плейсхолдер телефона не соответствует ожидаемому");
    assertEquals(communicationServices.getSumPlaceholder(), "Сумма", "Плейсхолдер суммы не соответствует ожидаемому");
    assertEquals(communicationServices.getEmailPlaceholder(), "E-mail для отправки чека", "Плейсхолдер e-mail не соответствует ожидаемому");
    }

    @AfterEach
        public void tearDown() {
            if (driver != null) {
                driver.quit();
        }
    }
}






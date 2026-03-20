package com.example.tests;

import com.example.pages.Installment;
import com.example.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;


public class InstallmentTest {
    private WebDriver driver;
    private MainPage mainPage;
    private Installment installment;

     @BeforeEach
     public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        installment = new Installment(driver);
        driver.get("https://mts.by/");
        mainPage.closeButtonLocator();
}

@Test
    public void checkPlaceholdersInInstallmentSection() {
    installment = mainPage.goToInstallment(); 
     
    assertTrue(installment.isInstallmentCheckFieldVisible(), "Поле ввода номера счета не видно");
    assertTrue(installment.isInstallmentSumFieldVisible(), "Поле ввода суммы не видно");
    assertTrue(installment.isInstallmentEmailFieldVisible(), "Поле ввода e-mail не видно");

    assertEquals(installment.getInstallmentCheckPlaceholder(), "Номер счета на 44", "Плейсхолдер номерв счета не соответствует ожидаемому");
    assertEquals(installment.getInstallmentSumPlaceholder(), "Сумма", "Плейсхолдер суммы не соответствует ожидаемому");
    assertEquals(installment.getInstallmentEmailPlaceholder(), "E-mail для отправки чека", "Плейсхолдер e-mail не соответствует ожидаемому");

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



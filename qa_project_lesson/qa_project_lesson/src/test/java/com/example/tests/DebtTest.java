package com.example.tests;

import com.example.pages.Debt;
import com.example.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class DebtTest {
    private WebDriver driver;
    private MainPage mainPage;
    private Debt debt;

    @BeforeEach
     public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        debt = new Debt(driver);
        driver.get("https://mts.by/");
        mainPage.closeButtonLocator();
}

@Test
    public void checkPlaceholdersInDebtSection() {
    debt = mainPage.goToDebt(); 

    assertTrue(debt.isDebtCheckFieldVisible(), "Поле ввода номера счета не видно");
    assertTrue(debt.isDebtSumFieldVisible(), "Поле ввода суммы не видно");
    assertTrue(debt.isDebtEmailFieldVisible(), "Поле ввода e-mail не видно");

    assertEquals(debt.getDebtCheckPlaceholder(), "Номер счета на 2073", "Плейсхолдер телефона не соответствует ожидаемому");
    assertEquals(debt.getDebtSumPlaceholder(), "Сумма", "Плейсхолдер суммы не соответствует ожидаемому");
    assertEquals(debt.getDebtEmailPlaceholder(), "E-mail для отправки чека", "Плейсхолдер e-mail не соответствует ожидаемому");

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

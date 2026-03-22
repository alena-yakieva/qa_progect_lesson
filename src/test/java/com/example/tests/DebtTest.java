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

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.Description;

@Epic("UI Testing")
@Feature("Debt Page")
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
@Story("Проверка надписей в полях в разделе Задолженность")
@Severity(SeverityLevel.CRITICAL)
@Description("Проверяет видимость полей и корректность надписей")
    public void checkPlaceholdersInDebtSection() {
    debt = mainPage.goToDebt(); 
    debtCheckField();
    debtSumField();
    debtEmailField();
    }

@Step("Проверка поля номера счета")
private void debtCheckField() {
    assertTrue(debt.isDebtCheckFieldVisible(), "Поле ввода номера счета не видно");
    assertEquals(debt.getDebtCheckPlaceholder(), "Номер счета на 2073", "Плейсхолдер телефона не соответствует ожидаемому");
}
@Step("Проверка поля суммы")
private void debtSumField() {
    assertTrue(debt.isDebtSumFieldVisible(), "Поле ввода суммы не видно");
    assertEquals(debt.getDebtSumPlaceholder(), "Сумма", "Плейсхолдер суммы не соответствует ожидаемому");
}
@Step("Проверка поля e‑mail")
private void debtEmailField() {
    assertTrue(debt.isDebtEmailFieldVisible(), "Поле ввода e-mail не видно");    
    assertEquals(debt.getDebtEmailPlaceholder(), "E-mail для отправки чека", "Плейсхолдер e-mail не соответствует ожидаемому");
}
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

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

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

@Epic("UI Testing")
@Feature("Installment Page")

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
@Story("Проверка надписей в полях в разделе Рассрочка")
@Severity(SeverityLevel.CRITICAL)
@Description("Проверяет видимость полей и корректность надписей")
    public void checkPlaceholdersInInstallmentSection() {
    installment = mainPage.goToInstallment(); 
    installmentCheckField();
    installmentSumField();
    installmentEmailField();
    }
     
@Step("Проверка поля номер счета")
private void installmentCheckField() {   
    assertTrue(installment.isInstallmentCheckFieldVisible(), "Поле ввода номера счета не видно");
    assertEquals(installment.getInstallmentCheckPlaceholder(), "Номер счета на 44", "Плейсхолдер номера счета не соответствует ожидаемому");
}
@Step("Проверка поля сумма")
private void installmentSumField() {   
    assertTrue(installment.isInstallmentSumFieldVisible(), "Поле ввода суммы не видно");
    assertEquals(installment.getInstallmentSumPlaceholder(), "Сумма", "Плейсхолдер суммы не соответствует ожидаемому");
}
    
@Step("Проверка поля e-mail")
private void installmentEmailField() {
    assertTrue(installment.isInstallmentEmailFieldVisible(), "Поле ввода e-mail не видно");   
    assertEquals(installment.getInstallmentEmailPlaceholder(), "E-mail для отправки чека", "Плейсхолдер e-mail не соответствует ожидаемому");
}

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



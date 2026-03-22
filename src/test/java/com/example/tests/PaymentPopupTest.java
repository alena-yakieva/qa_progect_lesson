package com.example.tests;

import com.example.pages.PaymentPopup;
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
@Feature("PaymentPopup Page")

public class PaymentPopupTest {
    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPopup paymentPopup;

    @BeforeEach
     public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        paymentPopup = new PaymentPopup(driver);
        driver.get("https://mts.by/");
        mainPage.closeButtonLocator();
    }

@Test
@Story("Проверка заполнения данных и корректности их отображения во всплывающем окне раздела Услуги связи, и проверка незаполненных полей ")
@Severity(SeverityLevel.CRITICAL)
@Description("Проверяет видимость полей и корректность надписей")
    public void testPaymentPopupOpens() {
      mainPage.goToPaymentPopup();
      checkDisplayAmount();
      checkPhoneNumber();
      checkCardNumberLabel();
      checkExpiryDateLabel();
      checkCvcLabel();
      checkNameOnCardLabel();
      checkCardImg();
      checkButtonText();
    }
@Step("Проверка поля отображения суммы")
private void checkDisplayAmount() {     
        String displayAmount = paymentPopup.getDisplayedAmount();
        assertNotNull(displayAmount);
        assertTrue(displayAmount.contains("50.00"), "Сумма 50.00 BYN");
        assertEquals("50.00", displayAmount, "Сумма 50.00 BYN");
}
@Step("Проверка поля отображения номера телефона")
private void checkPhoneNumber() {
        String phoneNumber = paymentPopup.getPhoneNumberValue();
        assertNotNull(phoneNumber);
        assertFalse(phoneNumber.isEmpty());
        assertTrue(phoneNumber.contains("297777777"), "Номер телефона должен содержать введённые цифры");
        assertEquals("Оплата: Услуги связи Номер:375297777777", phoneNumber, "Номер телефона должен быть в формате 375XXXXXXXX");
} 
@Step("Проверка поля номера карты")
private void checkCardNumberLabel() {     
        assertTrue(paymentPopup.isCardNumberLabelVisible());
        assertEquals("Номер карты", paymentPopup.getCardNumberLabelText());
}
@Step("Проверка поля срока действия")
private void checkExpiryDateLabel() {
        assertTrue(paymentPopup.isExpiryDateLabelVisible());
        assertEquals("Срок действия", paymentPopup.getExpiryDateLabelText());
}
@Step("Проверка поля CVC")
private void checkCvcLabel() {
        assertTrue(paymentPopup.isCvcLabelVisible());
        assertEquals("CVC", paymentPopup.getCvcLabelText());
}
@Step("Проверка поля Имя и фамилия на карте")
private void checkNameOnCardLabel() {
        assertTrue(paymentPopup.isNameOnCardLabelVisible());
        assertEquals("Имя и фамилия на карте", paymentPopup.getNameOnCardLabelText());
}
@Step("Проверка наличия иконок платежных систем")
private void checkCardImg() {
        assertTrue(paymentPopup.isVisaImgVisible());
        assertTrue(paymentPopup.isMastercardImgVisible());
        assertTrue(paymentPopup.isBelcartImgVisible());
        assertTrue(paymentPopup.isMirImgVisible());
        assertTrue(paymentPopup.isMaestroImgVisible());
}
@Step("Проверка отображения суммы на кнопке оплаты")
private void checkButtonText() {
        String continueButtonText = paymentPopup.continueButtonText();
        assertNotNull(continueButtonText, "Текст кнопки подтверждения не найден");
        assertTrue(continueButtonText.contains("50"));
}

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

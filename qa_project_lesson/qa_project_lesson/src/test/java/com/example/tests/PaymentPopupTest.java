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
    public void testPaymentPopupOpens() {
      mainPage.goToPaymentPopup();
     
        String displayAmount = paymentPopup.getDisplayedAmount();
        assertNotNull(displayAmount);
        assertTrue(displayAmount.contains("50.00"), "Сумма 50.00 BYN");
        assertEquals("50.00", displayAmount, "Сумма 50.00 BYN");
    
        String phoneNumber = paymentPopup.getPhoneNumberValue();
        assertNotNull(phoneNumber);
        assertFalse(phoneNumber.isEmpty());
        assertTrue(phoneNumber.contains("297777777"), "Номер телефона должен содержать введённые цифры");
        assertEquals("Оплата: Услуги связи Номер:375297777777", phoneNumber, "Номер телефона должен быть в формате 375XXXXXXXX");
        
        assertTrue(paymentPopup.isCardNumberLabelVisible());
        assertEquals("Номер карты", paymentPopup.getCardNumberLabelText());

        assertTrue(paymentPopup.isExpiryDateLabelVisible());
        assertEquals("Срок действия", paymentPopup.getExpiryDateLabelText());

        assertTrue(paymentPopup.isCvcLabelVisible());
        assertEquals("CVC", paymentPopup.getCvcLabelText());

        assertTrue(paymentPopup.isNameOnCardLabelVisible());
        assertEquals("Имя и фамилия на карте", paymentPopup.getNameOnCardLabelText());

        assertTrue(paymentPopup.isVisaImgVisible());
        assertTrue(paymentPopup.isMastercardImgVisible());
        assertTrue(paymentPopup.isBelcartImgVisible());
        assertTrue(paymentPopup.isMirImgVisible());
        assertTrue(paymentPopup.isMaestroImgVisible());

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

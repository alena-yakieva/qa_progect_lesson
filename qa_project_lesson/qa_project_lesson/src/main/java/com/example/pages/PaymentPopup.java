package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


    public class PaymentPopup extends MainPage {
        private WebDriver driver;
        private WebDriverWait wait;

    private static final By PHONE_INPUT = MainPage.PHONE_INPUT;
    private static final By SUM_INPUT = MainPage.SUM_INPUT;
    
    private static final By POPUP_SUM = MainPage.POPUP_SUM;
    private static final By POPUP_PHONE = MainPage.POPUP_PHONE;
    private static final By POPUP_CARD = MainPage.POPUP_CARD;
    private static final By POPUP_DATACONTROL = MainPage.POPUP_DATACONTROL;
    private static final By POPUP_CVC = MainPage.POPUP_CVC;
    private static final By POPUP_NAME_CARD = MainPage.POPUP_NAME_CARD;
    private static final By POPUP_VISA_IMG = MainPage.POPUP_VISA_IMG;
    private static final By POPUP_MASTERCARD_IMG = MainPage.POPUP_MASTERCARD_IMG;
    private static final By POPUP_BELCART_IMG = MainPage.POPUP_BELCART_IMG;
    private static final By POPUP_MIR_IMG = MainPage.POPUP_MIR_IMG;
    private static final By POPUP_PAY = MainPage.POPUP_PAY;
    private static final By POPUP_MAESTRO_IMG =MainPage. POPUP_MAESTRO_IMG;
        
    public PaymentPopup(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void switchToPaymentIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
            By.cssSelector("iframe.payment-widget-iframe")));
    }

    private void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

    public void phone(String phoneValue) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(PHONE_INPUT));
        phoneField.clear();
        phoneField.sendKeys(phoneValue);
    }

    public void sum(String sumValue) {
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(SUM_INPUT));
         wait.until(ExpectedConditions.elementToBeClickable(SUM_INPUT));
        sumField.clear();
        sumField.sendKeys(sumValue);
    }

    public String getPhoneValue() {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_INPUT));
        return phoneField.getAttribute("value");
    }

    public String getSumValue() {
        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(SUM_INPUT));
        return sumField.getAttribute("value");
    }

    public String getDisplayedAmount() {
        switchToPaymentIframe();
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_SUM));
        String amountText = amountElement.getText().trim();
        switchToMainContent();
        return amountText.split(" ")[0];
    }

    public String getPhoneNumberValue() {
    switchToPaymentIframe();
        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_PHONE));
        String phoneNumberText = phoneNumber.getText().trim();
        switchToMainContent();
        return phoneNumberText;

}
    
    public boolean isCardNumberLabelVisible() {
    try {
        switchToPaymentIframe();
        WebElement cardNumberLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_CARD));
        return cardNumberLabel.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент label не виден или не найден: " + e.getMessage());
        return false;
    } finally {
        switchToMainContent();
    }
}

public String getCardNumberLabelText() {
    try {
        switchToPaymentIframe();
        WebElement cardNumberLabel = wait.until(ExpectedConditions.presenceOfElementLocated(POPUP_CARD));
        String labelText = cardNumberLabel.getText();
        if (labelText == null || labelText.isEmpty()) {
            System.err.println("Текст в label с 'Номер карты' отсутствует");
        }
        return labelText != null ? labelText : "";
    } catch (Exception e) {
        System.err.println("Не удалось получить текст label с 'Номер карты': " + e.getMessage());
        return "";
    } finally {
        switchToMainContent();
    }
}

    public boolean isExpiryDateLabelVisible() {
        try {
        switchToPaymentIframe();
        WebElement expiryDateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_DATACONTROL));
        return expiryDateLabel.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент label не виден или не найден: " + e.getMessage());
        return false;
    } finally {
        switchToMainContent();
    }
}

    public String getExpiryDateLabelText() {
         try {
        switchToPaymentIframe();
        WebElement ExpiryDateLabel = wait.until(ExpectedConditions.presenceOfElementLocated(POPUP_DATACONTROL));
        String labelText = ExpiryDateLabel.getText();
        if (labelText == null || labelText.isEmpty()) {
            System.err.println("Текст в label с 'Срок действия' отсутствует");
        }
        return labelText != null ? labelText : "";
    } catch (Exception e) {
        System.err.println("Не удалось получить текст label с 'Срок действия': " + e.getMessage());
        return "";
    } finally {
        switchToMainContent();
    }
}

    public boolean isCvcLabelVisible() {
        try {
        switchToPaymentIframe();
        WebElement cvcLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_CVC));
        return cvcLabel.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент label не виден или не найден: " + e.getMessage());
        return false;
    } finally {
        switchToMainContent();
    }
}

    public String getCvcLabelText() {
        try {
        switchToPaymentIframe();
        WebElement cvcLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_CVC));
        String labelText = cvcLabel.getText();
        if (labelText == null || labelText.isEmpty()) {
            System.err.println("Текст в label с 'CVC' отсутствует");
        }
        return labelText != null ? labelText : "";
    } catch (Exception e) {
        System.err.println("Не удалось получить текст label с 'CVC': " + e.getMessage());
        return "";
    } finally {
        switchToMainContent();
    }
}

    public boolean isNameOnCardLabelVisible() {
        try {
        switchToPaymentIframe();
        WebElement nameOnCardLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_NAME_CARD));
        return nameOnCardLabel.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент label не виден или не найден: " + e.getMessage());
        return false;
    } finally {
        switchToMainContent();
    }
}

    public String getNameOnCardLabelText() {
        try {
        switchToPaymentIframe();
        WebElement nameOnCardLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_NAME_CARD));
        String labelText = nameOnCardLabel.getText();
        if (labelText == null || labelText.isEmpty()) {
            System.err.println("Текст в label с 'Имя и фамилия на карте' отсутствует");
        }
        return labelText != null ? labelText : "";
    } catch (Exception e) {
        System.err.println("Не удалось получить текст label с 'Имя и фамилия на карте': " + e.getMessage());
        return "";
    } finally {
        switchToMainContent();
    }
}

    public boolean isVisaImgVisible() {
        try {
        switchToPaymentIframe();
        WebElement visaImg = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_VISA_IMG));
        return visaImg.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент img не виден или не найден: " + e.getMessage());
        return false;
    } finally {
        switchToMainContent();
    }     
    }

    public boolean isMastercardImgVisible() {
        try {
        switchToPaymentIframe();
        WebElement mastercardImg = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_MASTERCARD_IMG));
        return mastercardImg.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент img не виден или не найден: " + e.getMessage());
        return false;
    } finally {
        switchToMainContent();
    }
}

    public boolean isBelcartImgVisible() {
        try {
        switchToPaymentIframe();
        WebElement belcartImg = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_BELCART_IMG));
        return belcartImg.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент img не виден или не найден: " + e.getMessage());
        return false;
    } finally {
        switchToMainContent();
    }
}

    public boolean isMirImgVisible() {
        try {
        switchToPaymentIframe();
            WebElement mirImg = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_MIR_IMG));
        return mirImg.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент img не виден или не найден: " + e.getMessage());
        return false;
    } finally {
        switchToMainContent();
    }
}

     public boolean isMaestroImgVisible() {
        try {
        switchToPaymentIframe();
        WebElement maestroImg = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_MAESTRO_IMG));
        return maestroImg.isDisplayed();
    } catch (Exception e) {
        System.err.println("Элемент img не виден или не найден: " + e.getMessage());
        return false;
    } finally {   
        switchToMainContent();
    }
}

     public boolean isElementVisible(By locator, int timeoutSeconds) {
        try {
            switchToPaymentIframe();
            WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            WebElement element = localWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            boolean isDisplayed = element.isDisplayed();
            switchToMainContent();
            return isDisplayed;
        } catch (org.openqa.selenium.TimeoutException e) {
            switchToMainContent();
            return false;
        }
    }

    public String continueButtonText() {
        switchToPaymentIframe();
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_PAY));
        String buttonText = continueButton.getText();
        switchToMainContent();
        return buttonText;
    }

    public boolean isPayButtonVisible() {
        switchToPaymentIframe();
        boolean isVisible = isElementVisible(POPUP_PAY, 5);
        switchToMainContent();
        return isVisible;
    }
}

package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
   
    public static final By BUTTON_LOCATOR = By.xpath("//button[contains(text(), 'Принять')]");
    public static final By SERVICES_BUTTON = By.xpath("//h2[contains(., 'Онлайн пополнение без комиссии')]");
    public static final By DROPDOWN_ARROW = By.xpath("//button[@class='select__header']");
        
    public static final By COMMUNICATION_INPUT = By.xpath("//p[@class='select__option' and text()='Услуги связи']");
    public static final By HOME_INTERNET_INPUT = By.xpath("//p[@class='select__option' and text()='Домашний интернет']");
    public static final By INSTALLMENT_INPUT = By.xpath("//p[@class='select__option' and text()='Рассрочка']");
    public static final By DEBT_INPUT = By.xpath("//p[@class='select__option' and text()='Задолженность']");

    public static final By PHONE_INPUT = By.xpath("//input[@placeholder='Номер телефона' and @id='connection-phone']");
    public static final By SUM_INPUT = By.xpath("//input[@placeholder='Сумма' and @id='connection-sum']");
    public static final By EMAIL_INPUT = By.xpath("//input[@placeholder='E-mail для отправки чека' and @id='connection-email']");

    public static final By HOME_INTERNET_PHONE_INPUT = By.xpath("//input[@id='internet-phone' and @placeholder='Номер абонента']");
    public static final By HOME_INTERNET_SUM_INPUT = By.xpath("//input[@id='internet-sum' and @placeholder='Сумма']");
    public static final By HOME_INTERNET_EMAIL_INPUT = By.xpath("//input[@id='internet-email' and @placeholder='E-mail для отправки чека']");

    public static final By INSTALLMENT_CHECK_INPUT = By.xpath("//input[@id='score-instalment' and @placeholder='Номер счета на 44']");
    public static final By INSTALLMENT_SUM_INPUT = By.xpath("//input[@id='instalment-sum' and @placeholder='Сумма']");
    public static final By INSTALLMENT_EMAIL_INPUT = By.xpath("//input[@id='instalment-email' and @placeholder='E-mail для отправки чека']");
    
    public static final By DEBT_CHECK_INPUT = By.xpath("//input[@placeholder='Номер счета на 2073' and @id='score-arrears']");
    public static final By DEBT_SUM_INPUT = By.xpath("//input[@placeholder='Сумма' and @id='arrears-sum']");
    public static final By DEBT_EMAIL_INPUT = By.xpath("//input[@placeholder='E-mail для отправки чека' and @id='arrears-email']");

    public static final By CONTINUE_BUTTON = By.xpath("//button[contains(text(), 'Продолжить')]");
    public static final By POPUP_CONTAINER = By.xpath("By.xpath(\"//div[contains(@class, 'app-wrapper__content-container') and contains(@class, 'app-wrapper__content-container_full')]");

    public static final By POPUP_SUM = By.xpath("//span[contains(@class, 'ng-star-inserted') and contains(., 'BYN')]");
    public static final By POPUP_PHONE = By.xpath("//span[contains(text(), 'Номер:')]");
    public static final By POPUP_CARD = By.xpath("//label[contains(text(), 'Номер карты')]");
    public static final By POPUP_DATACONTROL = By.xpath("//label[contains(text(),'Срок действия')]");
    public static final By POPUP_CVC = By.xpath("//label[contains(text(), 'CVC')]"); 
    public static final By POPUP_NAME_CARD = By.xpath("//label[contains(text(), 'Имя и фамилия на карте')]");
    
    public static final By POPUP_VISA_IMG = By.xpath("//img[contains(@src, 'visa-system.svg')]");
    public static final By POPUP_MASTERCARD_IMG = By.xpath("//img[contains(@src, 'mastercard-system.svg')]");
    public static final By POPUP_BELCART_IMG = By.xpath("//img[contains(@src, 'belkart-system.svg')]");
    public static final By POPUP_MIR_IMG = By.xpath("//img[contains(@src, 'mir-system-ru')]"); 
    public static final By POPUP_MAESTRO_IMG = By.xpath("//img[contains(@src, 'maestro-system')]");
   
    public static final By POPUP_PAY = By.xpath("//span[contains(text(), 'Оплатить')]");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
    }
    
    public MainPage closeButtonLocator() {
        if (wait == null) {
        throw new RuntimeException("WebDriverWait не инициализирован. Проверьте вызов super(driver) в конструкторе MainPage.");
    }
        try {
             WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(BUTTON_LOCATOR));
        closeButton.click();

    } catch (org.openqa.selenium.TimeoutException e) {
            
        } catch (Exception e) {
            
        }
        return this;
    }

    public MainPage openDropdownMenu() {
        WebElement dropArrow = wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN_ARROW));        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dropArrow);
        dropArrow.click();
        return this;
    }

    public MainPage continueButton() {
        try {
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(CONTINUE_BUTTON));
        continueButton.click();

        } catch (org.openqa.selenium.TimeoutException e) {
            throw new RuntimeException("Кнопка 'Продолжить' не найдена за 20 секунд", e);          
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при нажатии кнопки 'Продолжить'", e);            
        }
        return this;
    }

       
    public CommunicationServices goToCommunicationServices() {
        WebElement servicesButton = wait.until(ExpectedConditions.elementToBeClickable(SERVICES_BUTTON));
        servicesButton.click();
        openDropdownMenu();
        WebElement communicationInput = wait.until(ExpectedConditions.elementToBeClickable(COMMUNICATION_INPUT));
        communicationInput.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_INPUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUM_INPUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));
        return new CommunicationServices(driver);
    }
    
    public HomeInternet goToHomeInternet() {
        WebElement servicesButton = wait.until(ExpectedConditions.elementToBeClickable(SERVICES_BUTTON));
        servicesButton.click();
        openDropdownMenu();
        WebElement homeInternetButton = wait.until(ExpectedConditions.elementToBeClickable(HOME_INTERNET_INPUT));
        homeInternetButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_INTERNET_PHONE_INPUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_INTERNET_SUM_INPUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_INTERNET_EMAIL_INPUT));
        return new HomeInternet(driver);
    }


    public Installment goToInstallment() {
        WebElement servicesButton = wait.until(ExpectedConditions.elementToBeClickable(SERVICES_BUTTON));
        servicesButton.click();
        openDropdownMenu();
        WebElement installmentButton = wait.until(ExpectedConditions.elementToBeClickable(INSTALLMENT_INPUT));
        installmentButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(INSTALLMENT_CHECK_INPUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(INSTALLMENT_SUM_INPUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(INSTALLMENT_EMAIL_INPUT));
        return new Installment(driver);
    }

    public Debt goToDebt() {
        WebElement servicesButton = wait.until(ExpectedConditions.elementToBeClickable(SERVICES_BUTTON));
        servicesButton.click();
        openDropdownMenu();   
        WebElement debtButton = wait.until(ExpectedConditions.elementToBeClickable(DEBT_INPUT));
        debtButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DEBT_CHECK_INPUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(DEBT_SUM_INPUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(DEBT_EMAIL_INPUT));
        return new Debt(driver);    
    }
    
    public PaymentPopup goToPaymentPopup() {
        WebElement servicesButton = wait.until(ExpectedConditions.elementToBeClickable(SERVICES_BUTTON));
        servicesButton.click();
        openDropdownMenu();
        WebElement communicationInput = wait.until(ExpectedConditions.elementToBeClickable(COMMUNICATION_INPUT));
        communicationInput.click();
         WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_INPUT));
        phoneField.clear();
        phoneField.sendKeys("297777777");

        WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(SUM_INPUT));
        sumField.clear();
        sumField.sendKeys("50");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(CONTINUE_BUTTON));
        continueButton.click();
    
        return new PaymentPopup(driver);
    }
}



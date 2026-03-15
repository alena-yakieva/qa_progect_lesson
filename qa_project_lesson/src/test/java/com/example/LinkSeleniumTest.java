package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class LinkSeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    void testLink() {
        driver.get("https://mts.by/");

        try {
            By acceptButtonLocator = By.xpath(
                ("//button[contains(text(), 'Принять')]"));

            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptButtonLocator));
            acceptButton.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptButton));
            System.out.println("Cookie banner accepted");
        } catch (Exception e) {
        }

        By linkLocator = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");

        try {
            WebElement infoLink = wait.until(ExpectedConditions.elementToBeClickable(linkLocator));

            assertTrue(infoLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается на странице");
            assertTrue(infoLink.isEnabled(), "Ссылка 'Подробнее о сервисе' неактивна");

            String linkHref = infoLink.getAttribute("href");
            assertNotNull(linkHref, "Атрибут href ссылки 'Подробнее о сервисе' отсутствует или пуст");
            assertNotEquals("", linkHref, "Атрибут href ссылки 'Подробнее о сервисе' пуст");

            String originalUrl = driver.getCurrentUrl();
            infoLink.click();

            wait.until(driver1 -> !driver1.getCurrentUrl().equals(originalUrl));
            String newUrl = driver.getCurrentUrl();

            assertNotEquals(originalUrl, newUrl, "Страница не изменилась после клика по ссылке");
           
        } catch (org.openqa.selenium.TimeoutException e) {
            fail("Таймаут ожидания изменения URL после клика по ссылке: " + e.getMessage());

        } catch (Exception e) {
            fail("Ошибка при проверке ссылки 'Подробнее о сервисе': " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

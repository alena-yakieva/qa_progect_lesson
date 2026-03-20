package com.example.utils;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {
    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    public static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), TIMEOUT);
    }
}

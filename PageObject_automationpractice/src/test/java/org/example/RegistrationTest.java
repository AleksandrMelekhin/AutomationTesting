package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String STORE_URL = "http://automationpractice.com";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        driver.get(STORE_URL);
        driver.manage().window().maximize();
    }

    @Epic(value = "Регистрация нового пользователя")
    @Feature(value = "Регистрация")
    @Story(value = "Позитивная регистрация")
    @Test
    void PositiveRegistration() throws InterruptedException {
        driver.get(STORE_URL);
        new MainPage(driver)
                .clickSignInButton();
        new LoginPage(driver)
                .registrationNewUser();
        new RegistrationPage(driver)
                .createNewAccount();
        new MyAccountPage(driver)
                .checkPositiveRegistration();
    }

    @AfterEach
    void tearDown() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry log : logEntries) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }
        driver.quit();
    }
}
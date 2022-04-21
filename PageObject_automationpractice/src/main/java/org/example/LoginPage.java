package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "passwd")
    private WebElement passwordField;
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;
    @Step("Логин")
    public MyAccountPage login(String email, String pass) {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        submitButton.click();
        return new MyAccountPage(driver);
    }

    @Step("Проверить позитивную авторизацию")
    public void checkPositiveLogin() {
        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//span[contains(., 'firstname')]")), isDisplayed()),
                () -> assertThat(driver.findElement(By.xpath("//a[@class='logout']")), isDisplayed())
        );
    }
    @Step("Проверить негативную авторизацию")
    public void checkNegativeLogin() {
        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//div[@class='alert alert-danger']")), isDisplayed()),
                () -> assertThat(driver.findElement(By.xpath("//div[@class='alert alert-danger']//p")), hasText("There is 1 error")),
                () -> assertThat(driver.findElement(By.xpath("//div[@class='alert alert-danger']//li")), hasText("Authentication failed."))
        );
    }
}


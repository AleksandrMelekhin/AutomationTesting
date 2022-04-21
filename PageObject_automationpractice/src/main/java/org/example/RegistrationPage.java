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


public class RegistrationPage extends BaseView {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "id_gender1")
    private WebElement genderRadioButton;
    @FindBy(id = "customer_firstname")
    private WebElement firstnameField;
    @FindBy(id = "customer_lastname")
    private WebElement lastnameField;
    @FindBy(id = "passwd")
    private WebElement passwordField;
    @FindBy(id = "address1")
    private WebElement addressField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "id_state")
    private WebElement stateSelectField;
    @FindBy(xpath = "//select[@id='id_state']//option[@value='6']")
    private WebElement alaskaSelect;
    @FindBy(id = "postcode")
    private WebElement postalCode;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @Step("Заполнение обязательных полей и клик на кнопку Регистрация")
    public MyAccountPage createNewAccount() {
        webDriverWait.until(ExpectedConditions.visibilityOf(genderRadioButton));
        genderRadioButton.click();
        firstnameField.sendKeys("test");
        lastnameField.sendKeys("test");
        passwordField.sendKeys("1234567890");
        addressField.sendKeys("Lenina street");
        cityField.sendKeys("Test City");
        stateSelectField.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(alaskaSelect));
        alaskaSelect.click();
        postalCode.sendKeys("12345");
        mobilePhone.sendKeys("89999999999");
        registerButton.click();
        return new MyAccountPage(driver);
    }
}
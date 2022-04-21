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


public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;
    @Step("Клик на кнопку авторизации")
    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

    @FindBy(id = "search_query_top")
    public WebElement searchField;
    @FindBy(xpath = "//button[@name='submit_search']")
    public WebElement searchButton;
    @Step("Поиск товара")
    public SearchPage search(String request) {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(request);
        searchButton.click();
        return new SearchPage(driver);
    }
}


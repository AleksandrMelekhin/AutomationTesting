package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    // АВТОРИЗАЦИЯ
    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;
    @Step("Клик на кнопку авторизации")
    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

    // ПОИСК
    @FindBy(id = "search_query_top")
    public WebElement searchField;
    @FindBy(xpath = "//button[@name='submit_search']")
    public WebElement searchButton;
    @Step("Поиск товара")
    public SearchPage searchItem(String request) {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(request);
        searchButton.click();
        return new SearchPage(driver);
    }

    // КОРЗИНА
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartButton;
    @Step("Переход в корзину")
    public CartPage clickCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }
}


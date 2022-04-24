package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CartPage extends BaseView{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка пустой корзины")
    public void checkEmptyCart() {
        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//p[@class='alert alert-warning']")), isDisplayed()),
                () -> assertThat(driver.findElement(By.xpath("//p[@class='alert alert-warning']")), hasText("Your shopping cart is empty."))
        );
    }
}

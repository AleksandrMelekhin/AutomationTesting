package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class SearchPage extends BaseView{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement warningMessage;
    @Step("Проверить поиск некорректного товара")
    public void checkSearchIncorrectItem() {
        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//p[@class='alert alert-warning']")), isDisplayed()),
                () -> assertThat(driver.findElement(By.xpath("//p[@class='alert alert-warning']")), hasText("No results were found for your search \"qwerty\""))
        );
    }
}

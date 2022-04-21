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

public class MyAccountPage extends BaseView {
    public MyAccountPage(WebDriver driver) {
        super(driver);
        womenSuggestBlock = new WomenSuggestBlock(driver);
    }

    @Step("Проверить позитивную регистрацию")
    public void checkPositiveRegistration() {
        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//span[contains(., 'test')]")), isDisplayed()),
                () -> assertThat(driver.findElement(By.xpath("//a[@class='logout']")), isDisplayed()),
                () -> assertThat(driver.findElement(By.xpath("//h1[@class='page-heading']")), hasText("MY ACCOUNT"))
        );
    }

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenButton;
    @Step("Навести курсор мыши на раздел 'Женщины'")
    public WomenSuggestBlock hoverWomenButton() {
        actions.moveToElement(womenButton).build().perform();
        return womenSuggestBlock;
    }

    public WomenSuggestBlock womenSuggestBlock;
}


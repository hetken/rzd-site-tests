package tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    protected MainPage mainPage = new MainPage();

    protected SelenideElement directionFrom = $("#direction-from"),
                              directionTo = $("#direction-to"),
                              resetButtonDirectionFrom = $(".rzd-input__reset-button--direction-from"),
                              resetButtonDirectionTo = $(".rzd-input__reset-button--direction-to");

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        open("https://www.rzd.ru/");
    }
}

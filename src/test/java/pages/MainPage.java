package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import components.Components;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWindow;

public class MainPage {

    public MainPage inputStartingLocation(String city) {
        $("#direction-from").click();
        $(".rzd-direction-from").$(byText(city)).click();
        return this;
    }

    public MainPage inputDestinationLocation(String city) {
        $("#direction-to").click();
        $(".rzd-direction-to").$(byText(city)).click();
        return this;
    }

    public MainPage chooseDepartureDateFromDatepicker() {
        Components.chooseDepartureDateFromDatepicker();
        return this;
    }

    public MainPage chooseReturnDateFromDatepicker() {
        Components.chooseReturnDateFromDatepicker();
        return this;
    }

    public MainPage searchForConnection() {
        $(byTagAndText("a", "Найти")).click();
        return this;
    }

    public MainPage resetDirectionField(SelenideElement selector) {
        selector.click();
        return this;
    }

    public MainPage verifyCorrectReset(SelenideElement selector) {
        selector.shouldBe(attribute("nodeid", ""));
        return this;
    }

    public MainPage clickSwapButton() {
        $(".rzd-swap-directions-button").click();
        return this;
    }

    public MainPage verifyDirectionFromFieldValue(String value) {
        $("#direction-from").shouldBe(attribute("expresscode", value));
        return this;
    }

    public MainPage verifyDirectionToFieldValue(String value) {
        $("#direction-to").shouldBe(attribute("expresscode", value));
        return this;
    }

    public MainPage verifyCurrentUrl() {
        WebDriverRunner.url().contains("ticket.rzd.ru");
        closeWindow();
        return this;
    }
}

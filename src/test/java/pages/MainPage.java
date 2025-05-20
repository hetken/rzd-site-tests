package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import components.DatepickerComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWindow;

public class MainPage {

    protected DatepickerComponent datePicker = new DatepickerComponent();

    @Step("Выбрать в выпадающем списке пункт отправления")
    public MainPage inputStartingLocation(String city) {
        $("#direction-from").click();
        $(".rzd-direction-from").$(byText(city)).click();
        return this;
    }

    @Step("Выбрать в выпадающем списке пункт назначения")
    public MainPage inputDestinationLocation(String city) {
        $("#direction-to").click();
        $(".rzd-direction-to").$(byText(city)).click();
        return this;
    }

    @Step("Выбрать в дейтпикере дату отъезда")
    public MainPage chooseDepartureDateFromDatepicker() {
        datePicker.chooseDepartureDateFromDatepicker();
        return this;
    }

    @Step("Выбрать в дейтпикере дату обратного рейса")
    public MainPage chooseReturnDateFromDatepicker() {
        datePicker.chooseReturnDateFromDatepicker();
        return this;
    }

    @Step("Кликнуть на кнопку 'Найти'")
    public MainPage searchForConnection() {
        $(byTagAndText("a", "Найти")).click();
        return this;
    }

    @Step("Кликнуть на кнопку сброса поля направления")
    public MainPage resetDirectionField(SelenideElement selector) {
        selector.click();
        return this;
    }

    @Step("Проверить, что поле стало пустым")
    public MainPage verifyCorrectReset(SelenideElement selector) {
        selector.shouldBe(attribute("nodeid", ""));
        return this;
    }

    @Step("Кликнуть на кнопку смены направлений")
    public MainPage clickSwapButton() {
        $(".rzd-swap-directions-button").click();
        return this;
    }

    @Step("Проверить, что значение из поля 'Куда' подставилось в поле 'Откуда'")
    public MainPage verifyDirectionFromFieldValue(String value) {
        $("#direction-from").shouldBe(attribute("expresscode", value));
        return this;
    }

    @Step("Проверить, что значение из поля 'Откуда' подставилось в поле 'Куда'")
    public MainPage verifyDirectionToFieldValue(String value) {
        $("#direction-to").shouldBe(attribute("expresscode", value));
        return this;
    }

    @Step("Проверить адрес страницы ticket.rzd.ru")
    public MainPage verifyCurrentUrl() {
        WebDriverRunner.url().contains("ticket.rzd.ru");
        closeWindow();
        return this;
    }

    @Step("Проверить текст тултипа")
    public MainPage verifyWarningToolTip() {
        $(byText("Введите пункт отправления")).shouldBe(visible);
        return this;
    }
}

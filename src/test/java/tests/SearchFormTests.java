import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchFormTests extends TestBase {

    private String startingLocation = "Санкт-Петербург";
    private String destinationLocation = "Москва";
    private String moscowExpressCode = "2000000";
    private String petersburgExpressCode = "2004000";

    @Test
    @DisplayName("Проверить работу формы поиска с корректными данными")
    void checkFormWithCorrectData() {
        mainPage.inputStartingLocation(startingLocation)
                .inputDestinationLocation(destinationLocation)
                .chooseDepartureDateFromDatepicker()
                .chooseReturnDateFromDatepicker()
                .searchForConnection()
                .verifyCurrentUrl();
    }

    @Test
    @DisplayName("Проверить кнопку смены направлений")
    void checkDirectionChangeButton() {
        mainPage.inputStartingLocation(startingLocation)
                .inputDestinationLocation(destinationLocation)
                .clickSwapButton()
                .verifyDirectionFromFieldValue(moscowExpressCode)
                .verifyDirectionToFieldValue(petersburgExpressCode);
    }

    @Test
    @DisplayName("Проверить кнопку сброса значения поля 'Откуда'")
    void resetValueInFieldDirectionFrom() {
        mainPage.inputStartingLocation(startingLocation)
                .resetDirectionField(resetButtonDirectionFrom)
                .verifyCorrectReset(directionFrom);
    }

    @Test
    @DisplayName("Проверить кнопку сброса значения поля 'Куда'")
    void resetValueInFieldDirectionTo() {
        mainPage.inputDestinationLocation(destinationLocation)
                .resetDirectionField(resetButtonDirectionTo)
                .verifyCorrectReset(directionTo);
    }

    @Test
    @DisplayName("Проверить невозможность отправки пустой формы")
    void sendEmptyForm() {
        mainPage.searchForConnection()
                .verifyWarningToolTip();
    }
}

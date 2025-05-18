import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class SearchFormTests extends TestBase {

    private String startingLocation = "Санкт-Петербург";
    private String destinationLocation = "Москва";
    private String moscowExpressCode = "2000000";
    private String petersburgExpressCode = "2004000";

    @Test
    void checkFormWithCorrectData() {
        mainPage.inputStartingLocation(startingLocation)
                .inputDestinationLocation(destinationLocation)
                .chooseDepartureDateFromDatepicker()
                .chooseReturnDateFromDatepicker()
                .searchForConnection()
                .verifyCurrentUrl();
    }

    @Test
    void checkDirectionChangeButton() {
        mainPage.inputStartingLocation(startingLocation)
                .inputDestinationLocation(destinationLocation)
                .clickSwapButton()
                .verifyDirectionFromFieldValue(moscowExpressCode)
                .verifyDirectionToFieldValue(petersburgExpressCode);
    }

    @Test
    void resetValueInFieldDirectionFrom() {
        mainPage.inputStartingLocation(startingLocation)
                .resetDirectionField(resetButtonDirectionFrom)
                .verifyCorrectReset(directionFrom);
    }

    @Test
    void resetValueInFieldDirectionTo() {
        mainPage.inputDestinationLocation(destinationLocation)
                .resetDirectionField(resetButtonDirectionTo)
                .verifyCorrectReset(directionTo);
    }

    @Test
    void sendEmptyForm() {
        mainPage.searchForConnection()
                .verifyWarningToolTip();
    }
}

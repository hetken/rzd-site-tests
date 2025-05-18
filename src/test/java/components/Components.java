package components;

import static com.codeborne.selenide.Selenide.$;

public class Components {


    public static void chooseDepartureDateFromDatepicker() {
        $("#datepicker-from").click();
        $(".rzd-datepicker-group-last").$("td[data-day='1']").click();
    }

    public static void chooseReturnDateFromDatepicker() {
        $("#datepicker-to").click();
        $(".rzd-datepicker-group-first").$("td[data-day='1']").click();
    }
}

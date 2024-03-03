import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillForm() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alexei");
        $("#lastName").setValue("Sergeenko");
        $("#userEmail").setValue("alexeisergeenko@gmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("8109999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--016").click();
        $("#subjectsInput").setValue("Mat").pressEnter();
        $("#subjectsInput").setValue("P").pressEnter();
        $("#subjectsInput").setValue("Che").pressEnter();
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();
//        $("#uploadPicture").uploadFromClasspath("Фильтр Jira.png");
        $("#currentAddress").setValue("Moscow, Russia, Velozavodskaya str.");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"),
                text("Alexei Sergeenko"), text("alexeisergeenko@gmail.com"), text("Male"), text("8109999999"),
                text("16 January, 2000"), text("Mat, P, Che"), text("Sports, Reading, Music"),
                text("Moscow, NCR, Noida"));

    }
}

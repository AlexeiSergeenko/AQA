import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {

        $("#firstName").setValue("Alexei");
        $("#lastName").setValue("Sergeenko");
        $("#userEmail").setValue("alexeisergeenko@gmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("8109999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--015").click();

        $("#subjectsInput").setValue("Mat").pressEnter();
        $("#subjectsInput").setValue("P").pressEnter();
        $("#subjectsInput").setValue("Che").pressEnter();

        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("pic/1.jpg");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/pic/1.jpg"));

        $("#currentAddress").setValue("Moscow, Russia, Velozavodskaya str.");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#city").$(byText("Noida")).click();

//        $("#submit").click(ClickOptions.usingJavaScript());
        $("#submit").click();

        $(".modal-dialog").shouldHave(appear);
        $(".modal-dialog").shouldHave(text("Thanks for submitting the form"));
        sleep(5000);
    }
}

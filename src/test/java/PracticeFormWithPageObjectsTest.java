import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectsTest extends TestBase {

    @Test
    void fillFormTest() {

        RegistrationPage registrationPage = new RegistrationPage();
        new RegistrationPage().openPage();

        registrationPage.openPage()
                .setFirstName("Alexei")
                .setLastName("Sergeenko")
                .setEmail("alexeisergeenko@gmail.com")
                .setGender("Male")
                .setPhone("8109999999")
                .setBirthDate("15", "July", "1997");

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

        registrationPage.verifyResultsModalAppears();
    }
}

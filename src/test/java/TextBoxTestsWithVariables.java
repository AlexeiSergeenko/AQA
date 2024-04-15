import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTestsWithVariables extends TestBase {
    String endPoint = "/text-box/";
    public SelenideElement
            firstName = $("#userName"),
            email = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            output = $("#output");

    @Test
    void fillFromTest() {
        open(endPoint);
        firstName.sendKeys("Alexius");
        email.sendKeys("email@mail.com");
        currentAddress.sendKeys("currentAddress");
        permanentAddress.sendKeys("permanentAddress");
        submitButton.click();

        output.shouldHave(text("Alexius"),
                text("email@mail.com"),
                text("currentAddress"),
                text("permanentAddress"));
    }
}
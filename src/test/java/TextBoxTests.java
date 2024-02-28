import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFromTest() {
        open("/text-box");

        $("#userName").val("Alexius");
        $("#userEmail").val("alexius@mail.com");
        $("#currentAddress").val("MyCurrentAddress");
        $("#permanentAddress").val("HereIsMyPeremanentAddress");
        $("#submit").click();

        $("#output").shouldHave(text("Alexius"), text("alexius@mail.com"),
                    text("MyCurrentAddress"), text("HereIsMyPeremanentAddress"));
    }

}

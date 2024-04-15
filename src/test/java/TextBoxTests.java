import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        baseUrl = "https://demoqa.com/text-box";
    }

    @Test
    void fillFromTest() {
        open(baseUrl);

        $("#userName").val("Alexius");
        $("#userEmail").val("alexius@mail.com");
        $("#currentAddress").val("MyCurrentAddress");
        $("#permanentAddress").val("HereIsMyPeremanentAddress");
        $("#submit").scrollTo().click();

        $("#output").shouldHave(text("Alexius"),
                text("alexius@mail.com"),
                text("MyCurrentAddress"),
                text("HereIsMyPeremanentAddress"));
    }
}

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class GoogleTest {
    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "http://google.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void userCanSearch() {
        open("/");
        $(By.name("q")).val("selenide").pressEnter();
        $$(".srg .g").shouldHave(size(10));
        $$(".srg .g").get(1).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
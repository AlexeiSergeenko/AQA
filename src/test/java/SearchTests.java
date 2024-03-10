import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text; 
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

 public class SearchTests {
    @BeforeAll
    static void beforeall() {
        boolean holdBrowserOpen = true;
        String browserSize = "1920x1080";
        baseUrl = "https://www.google.com/";
        Configuration.browser = "chrome";

    }
    @Test
    void successfulSearchTest( ) {
        open(baseUrl);
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}

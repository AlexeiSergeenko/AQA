import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TrivioTests {
   @BeforeAll
   static void beforeall() {
       boolean holdBrowserOpen = true;
       String browserSize = "1920x1080";
       baseUrl = "https://login.trivio.ru/";
//     Configuration.browser = "edge";
   }
   @Test
   void successfulAuthorisation( ) {
       open(baseUrl);
       $("#inputLogin").sendKeys("demo");
       $("#inputPassword").sendKeys("demo");

       $("#button_submit").click();
   }
    @Test
    void aviaSearch() {
       $(".TopServiceSelect_navLink_ftWUt").click();
       $(byText("что будем искать?"));
    }
}

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://github.com/";

    }
   @Test
   void shouldFindSelenideRepositoryAtTheTop( ) {
       open(baseUrl);
       $(".search-input").click();
       $("#query-builder-test").setValue("selenide").pressEnter();
       $("a[href='/selenide/selenide']").click();
       $("#repo-content-pjax-container").shouldHave(text("selenide/selenide"));

       sleep(5000);
   }
}

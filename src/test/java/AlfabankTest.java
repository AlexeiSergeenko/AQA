import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {
    @Test
    void testAlfa() {
        open("http://alfabank.ru");
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Вклады и инвестиции"));
        $$(byText("Депозиты")).find(visible).click();
        $("body").shouldHave(text("обратная связь"));
//        $$("").parent
    }
}

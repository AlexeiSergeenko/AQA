import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CloseCookiePopup {
    @Test
    void closeCookiePopup() {
        open("https://www.otpbank.ru/retail/bank-services/");
        $(withText("Продолжая просмотр сайта")).shouldBe(visible);
        $(byTagAndText("strong", "Закрыть")).click();
        sleep(5000);
    }
}

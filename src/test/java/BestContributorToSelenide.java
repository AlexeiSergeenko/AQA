
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void andreiSolntsevShoudBeTheFirstContributor() {
//        String browserSize = "400x400";

        open("https://github.com/selenide/selenide");
    $("div.Layout-sidebar").$(byText("Contributors"))
                    .closest("h2").sibling(0).$$("li").first().hover();
    $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));
    screenshot("screen");
    }
}

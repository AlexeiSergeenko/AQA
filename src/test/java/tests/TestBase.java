/*

Класс TestBase, как правило, содержит общую настройку и конфигурацию для ваших тестов. Обычно его размещают в пакете, который содержит весь ваш тестовый код. Например, если ваши тесты находятся в пакете tests, то TestBase можно поместить в этот же пакет или в его родительский пакет.

 */
package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        executeJavaScript("$('#fixedban').remove();");

//        Configuration.baseUrl = "https://demoqa.com/text-box/";
//        Configuration.browser = "chrome";
    }
}

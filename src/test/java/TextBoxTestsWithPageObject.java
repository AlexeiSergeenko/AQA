import pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

/*

Тестовый класс TextBoxTestsWithPageObject использует класс TextBoxPage
для взаимодействия с элементами страницы и выполнения тестовых действий.
Это делает тест более модульным и поддерживаемым.

*/
public class TextBoxTestsWithPageObject {
    private final TextBoxPage textBoxPage = new TextBoxPage(); //это объявление переменной textBoxPage типа TextBoxPage и инициализация её экземпляром класса TextBoxPage.

    /*

    Давайте разберём это более подробно:
    private: это модификатор доступа, который ограничивает доступ к переменной только внутри
    этого класса TextBoxTestsWithPageObject, а не вне него.
    final: это ключевое слово, которое указывает, что переменная textBoxPage может быть присвоена
    только один раз и после этого её значение не может быть изменено
    TextBoxPage: это тип переменной, указывающий на класс TextBoxPage
    textBoxPage: это имя переменной
    Таким образом, это строка создаёт новый экземпляр класса TextBoxPage и сохраняет ссылку на него
    в переменной textBoxPage, которая теперь может использоваться в классе TextBoxTestsWithPageObject
    для доступа к методам и полям класса TextBoxPage с помощью переменной textBoxPage.

    */
    @Test
    void fillFormTest() {
        textBoxPage.openPage();
        /*

        textBoxPage.openPage() вызывает метод openPage() из объекта textBoxPage,
        который представляет страницу TextBoxPage. Этот метод, как следует из его
        названия, отвечает за открытие страницы. Внутри метода, обычно, используется
        функциональность фреймворка или библиотеки для открытия URL, указанного в переменной
        endPoint, которая является частью адреса страницы. В данном случае, предполагается,
        что метод openPage() внутри класса TextBoxPage использует функциональность Selenide
        или другой подобной библиотеки для открытия URL страницы, соответствующего значению
        переменной endPoint, то есть "/text-box/". Использование этого метода в тестах позволяет
        обеспечить начальное состояние страницы перед выполнением тестовых действий

        */

        textBoxPage.getFirstNameInput().sendKeys("Alexius");
        /*

        textBoxPage.getFirstNameInput() вызывает метод getFirstNameInput() из объекта textBoxPage,

        */
        textBoxPage.getEmailInput().sendKeys("email@mail.com");
        textBoxPage.getCurrentAddressInput().sendKeys("currentAddress");
        textBoxPage.getPermanentAddressInput().sendKeys("permanentAddress");
        textBoxPage.getSubmitButton().click();

        textBoxPage.getOutputElement().shouldHave(
                text("Alexius"),
                text("email@mail.com"),
                text("currentAddress"),
                text("permanentAddress")
        );
    }
}

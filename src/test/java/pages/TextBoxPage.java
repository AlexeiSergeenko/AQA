/*
Обычно классы Page Object помещают в отдельный пакет внутри вашего проекта. Например, вы можете создать пакет с названием pages и поместить ваш класс TextBoxPage внутрь этого пакета.
*/
package pages;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
/*

Для реализации паттерна Page Object в нашем случае,
мы можем выделить класс, представляющий страницу,
и вынести в него все элементы и методы для взаимодействия с ними.
Здесь класс TextBoxPage предоставляет доступ к элементам страницы.

 */
public class TextBoxPage extends TestBase {

    public void openPage() {
        String baseUrl = "https://demoqa.com/text-box/";
        open(baseUrl);
    }
/*

Метод openPage() открывает страницу TextBoxPage.

*/
    public SelenideElement getFirstNameInput() {

        return $("#userName");
    }
    /*

    Метод getFirstNameInput() возвращает элемент ввода имени пользователя.

    */

    public SelenideElement getEmailInput() {

        return $("#userEmail");
    }

    public SelenideElement getCurrentAddressInput() {

        return $("#currentAddress");
    }

    public SelenideElement getPermanentAddressInput() {

        return $("#permanentAddress");
    }

    public SelenideElement getSubmitButton() {

        return $("#submit");
    }

    public SelenideElement getOutputElement() {

        return $("#output");
    }
}
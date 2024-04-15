import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTestsWithFaker extends TestBase {
    Faker faker = new Faker();
    String endPoint = "/text-box/";
    String firstName = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String permanentAddress = faker.address().fullAddress();
    public SelenideElement
            firstNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            output = $("#output");

    @Test
    void fillFromTest() {
        open(endPoint);
        firstNameInput.sendKeys(firstName);
        emailInput.sendKeys(email);
        currentAddressInput.sendKeys(currentAddress);
        permanentAddressInput.sendKeys(permanentAddress);
        submitButton.click();

        output.shouldHave(text(firstName),
                text(email),
                text(currentAddress),
                text(permanentAddress));
    }
}
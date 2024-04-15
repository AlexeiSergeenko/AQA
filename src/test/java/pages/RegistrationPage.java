package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String title = "Student Registration Form";
    private SelenideElement
            firstname = $("#firstName"),
            lastname = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#genterWrapper"),
            phone = $("#userNumber");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(title));
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstname.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastname.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }
}
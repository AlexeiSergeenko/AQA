package pages;

import static com.codeborne.selenide.Selenide.$;

public class Name {
    public void name() {
        $("#firstName").setValue("Alexei");
        $("#lastName").setValue("Sergeenko");
        $("#userEmail").setValue("alexeisergeenko@gmail.com");
    }
}

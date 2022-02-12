package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Eugene");
        $("#lastName").setValue("Samoilov");
        $("#userEmail").setValue("samoilov@test.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");

        // BirthInput
        $("#dateOfBirthInput").click();
        //month
        $(".react-datepicker__month-select").click();
        $x("//option[contains(@value, '7')]").click();
        //year
        $(".react-datepicker__year-select").click();
        $x("//option[contains(@value, '1990')]").click();
        //day
        $(".react-datepicker__week ").$(byText("1")).click();
        //
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("unix.png");
        $("#currentAddress").setValue("Puskina, dom 1");
        $("#state").scrollTo().click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        //check:
        $(".table-responsive").shouldHave(
                text("Eugene Samoilov"),
                text("samoilov@test.ru"),
                text("Male"),
                text("1234567890"),
                text("01 August,1990"),
                text("Computer Science"),
                text("Sports"),
                text("unix.png"),
                text("Puskina, dom 1"),
                text("NCR Delhi")
        );
    }
}
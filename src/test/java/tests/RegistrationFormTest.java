package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();


    String firstName = "Eugene";
    String lastName = "Samoilov";
    String userEmail = "samoilov@test.ru";
    String gender = "Male";
    String userPhone = "1234567890";
    String birthDateDay = "1";
    String birthDateMouth = "August";
    String birthDateYear = "1990";
    String birthDate = this.birthDateDay + " " + this.birthDateMouth + "," + this.birthDateYear;
    String subjects = "Computer Science";
    String hobbies = "Sports";
    String file = "unix.png";
    String userAddress = "Puskina, dom 1";
    String userState = "NCR";
    String userCity = "Delhi";





    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(gender)
                .setUserPhone(userPhone)
                .setBirthDate(birthDateDay, birthDateMouth, birthDateYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setUploadFile(file)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmitBtn();

        //check:
        registrationPage
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Student Email", userEmail)
                .checkResultInModal("Gender", gender)
                .checkResultInModal("Mobile", userPhone)
                .checkResultInModal("Date of Birth", birthDate)
                .checkResultInModal("Subjects", subjects)
                .checkResultInModal("Hobbies", hobbies)
                .checkResultInModal("Picture", file)
                .checkResultInModal("Address", userAddress)
                .checkResultInModal("State and City", userState + " " + userCity);

    }
}
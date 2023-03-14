package Tests;

import PageObjects.TravellersHomePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

@Slf4j
public class SignUpTest extends BaseTest {
    @ParameterizedTest
    @DisplayName("Sign up test")
    @CsvSource({"Walter, Snow, 875654213, walterSnow123@"})
    public void validSignUp(String firstName, String lastName, String phoneNumber, String password) {
        log.info("Start sign up test");
        String message = new TravellersHomePage(driver)
                .signUpClick()
                .enterName(firstName)
                .enterLastName(lastName)
                .enterPhoneNumber(phoneNumber)
                .enterEmail(firstName + lastName + new Random().nextInt(1000) + "@example.com")
                .enterPassword(password)
                .confirmPassword(password)
                .goToLoggedUserPage()
                .getLoggedUserAlert();
        Assertions.assertEquals("Hi, " + firstName + " " + lastName, message);
    }

    @ParameterizedTest
    @DisplayName("Sign up with invalid email type")
    @CsvSource({"Walter, Snow, 875654213, walterSnow123@, The Email field must contain a valid email address."})
    public void shouldPrintIncorrectTypeOfEmail(String firstName, String lastName, String phoneNumber, String password, String errorMessage) {
        log.info("Start sign up test with incorrect email type");
        String message = new TravellersHomePage(driver)
                .signUpClick()
                .enterName(firstName)
                .enterLastName(lastName)
                .enterPhoneNumber(phoneNumber)
                .enterEmail(firstName + lastName + new Random().nextInt(1000))
                .enterPassword(password)
                .confirmPassword(password)
                .getAlertMessage();
        Assertions.assertEquals(errorMessage, message);
    }

    @Test
    @DisplayName("Sign up without entered any data")
    public void shouldPrintRequirementAlerts() {
        String errorMessage = String.join("\n", "The Email field is required.",
                "The Password field is required.", "The Password field is required.",
                "The First name field is required.", "The Last Name field is required.");
        log.info("Start sign up test without entering any data");
        String message = new TravellersHomePage(driver)
                .signUpClick()
                .getAlertMessage();
        Assertions.assertEquals(errorMessage, message);
    }
}

package Tests;

import PageObjects.TravellersHomePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Slf4j
public class LoginTest extends BaseTest {
    @ParameterizedTest
    @DisplayName("Login test")
    @CsvSource({"walter@example.com, walterSnow123@, Walter, Snow"})
    public void validLogIn(String email, String password, String firstName, String lastName) {
        log.info("Start log in test");
        String message = new TravellersHomePage(driver)
                .LoginClick()
                .enterEmail(email)
                .enterPassword(password)
                .goToUserLoggedPage()
                .getLoggedUserAlert();
        Assertions.assertEquals("Hi, " + firstName + " " + lastName, message);
        log.info("Finished log in test");
    }

    @ParameterizedTest
    @DisplayName("Incorrect data login test")
    @CsvSource({"wrong@example.com, wrong, Invalid Email or Password"})
    public void invalidLogIn(String email, String password, String alert) {
        log.info("Start invalid data log in test");
        String message = new TravellersHomePage(driver)
                .LoginClick()
                .enterEmail(email)
                .enterPassword(password)
                .getInvalidLoginDataMessage();
        Assertions.assertEquals(alert, message);
        log.info("Finished invalid data log in test");
    }
}

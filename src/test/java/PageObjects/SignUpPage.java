package PageObjects;

import Utils.HelperMethods;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class SignUpPage extends HelperMethods {
    private final WebDriver driver;
    @FindBy(css = "input[name='firstname']")
    private WebElement firstNameInput;
    @FindBy(css = "input[name='lastname']")
    private WebElement lastNameInput;
    @FindBy(css = "input[name='phone']")
    private WebElement phoneNumberInput;
    @FindBy(css = "input[name='email']")
    private WebElement emailInput;
    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;
    @FindBy(css = "input[name='confirmpassword']")
    private WebElement confirmPasswordInput;
    @FindBy(css = "button.btn-lg")
    private WebElement signUpBtn;
    @FindBy(css = ".alert-danger")
    private WebElement alertMessage;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignUpPage enterName(String name) {
        log.debug("Setting user name.");
        inputSendKeysHelper(firstNameInput, name);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        log.debug("Setting user last name.");
        inputSendKeysHelper(lastNameInput, lastName);
        return this;
    }

    public SignUpPage enterPhoneNumber(String phoneNumber) {
        log.debug("Setting user phone number.");
        inputSendKeysHelper(phoneNumberInput, phoneNumber);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        log.debug("Setting user e-mail.");
        inputSendKeysHelper(emailInput, email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        log.debug("Setting user password.");
        inputSendKeysHelper(passwordInput, password);
        return this;
    }

    public SignUpPage confirmPassword(String password) {
        log.debug("Confirming user password.");
        inputSendKeysHelper(confirmPasswordInput, password);
        return this;
    }

    public LoggedUserPage goToLoggedUserPage() {
        log.debug("Going to logged user page.");
        signUpBtn.click();
        return new LoggedUserPage(driver);
    }

    public String getAlertMessage() {
        log.debug("Getting alert message after entering invalid data.");
        signUpBtn.click();
        return alertMessage.getText();
    }
}

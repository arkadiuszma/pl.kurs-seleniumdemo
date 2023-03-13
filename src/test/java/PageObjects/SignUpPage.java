package PageObjects;

import Utils.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        inputSendKeysHelper(firstNameInput, name);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        inputSendKeysHelper(lastNameInput, lastName);
        return this;
    }

    public SignUpPage enterPhoneNumber(String phoneNumber) {
        inputSendKeysHelper(phoneNumberInput, phoneNumber);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        inputSendKeysHelper(emailInput, email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        inputSendKeysHelper(passwordInput, password);
        return this;
    }

    public SignUpPage confirmPassword(String password) {
        inputSendKeysHelper(confirmPasswordInput, password);
        return this;
    }

    public LoggedUserPage goToLoggedUserPage() {
        signUpBtn.click();
        return new LoggedUserPage(driver);
    }

    public String getAlertMessage() {
        signUpBtn.click();
        return alertMessage.getText();
    }
}

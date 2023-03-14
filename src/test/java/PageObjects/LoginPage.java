package PageObjects;

import Utils.HelperMethods;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends HelperMethods {
    private final WebDriver driver;
    @FindBy(css = "input[name='username']")
    private WebElement emailInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;
    @FindBy(css = "button.loginbtn")
    private WebElement loginBtn;

    @FindBy(css = ".alert-danger")
    private WebElement incorrectDataAlert;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage enterEmail(String email) {
        log.debug("Entering email.");
        inputSendKeysHelper(emailInput, email);
        return this;
    }

    public LoginPage enterPassword(String email) {
        log.debug("Entering password.");
        inputSendKeysHelper(passwordInput, email);
        return this;
    }

    public LoggedUserPage goToUserLoggedPage() {
        log.debug("Going to logged user page.");
        loginBtn.click();
        return new LoggedUserPage(driver);
    }

    public String getInvalidLoginDataMessage() {
        log.debug("Getting alert for invalid data.");
        loginBtn.click();
        return incorrectDataAlert.getText();
    }
}

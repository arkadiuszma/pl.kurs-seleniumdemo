package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    @FindBy(css = "h3.RTL")
    private WebElement userLoggedAlert;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getLoggedUserAlert() {
        return userLoggedAlert.getText();
    }
}

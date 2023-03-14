package PageObjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoggedUserPage {
    @FindBy(css = "h3.RTL")
    private WebElement userLoggedAlert;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getLoggedUserAlert() {
        log.debug("Getting alert from logged user.");
        return userLoggedAlert.getText();
    }
}

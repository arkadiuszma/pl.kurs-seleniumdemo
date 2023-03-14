package PageObjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class HotelResultPage {
    @FindBy(css = ".list_title")
    private List<WebElement> hotelList;

    public HotelResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getHotelNames() {
        log.debug("Getting hotel names");
        return hotelList.stream()
                .map(e -> e.getAttribute("textContent"))
                .collect(Collectors.toList());
    }
}

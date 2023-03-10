package Utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import java.util.stream.IntStream;

@Slf4j
public class HelperMethods {
    protected void inputSendKeysHelper(WebElement element, String inputText) {
        element.clear();
        element.sendKeys(inputText);
    }

    protected void forLoopAddingGuest(WebElement element, int startNumber, int guestNumber) {
        IntStream.range(startNumber, guestNumber).forEachOrdered(i -> element.click());
    }
}

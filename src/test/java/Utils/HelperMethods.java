package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

public class HelperMethods {
    protected void inputSendKeysHelper(WebElement element, String inputText) {
        element.clear();
        element.sendKeys(inputText);
    }

    protected void forLoopAddingGuest(WebElement element, int startNumber, int guestNumber) {
        IntStream.range(startNumber, guestNumber).forEachOrdered(i -> element.click());
    }

    protected WebElement getMatcherElementFromList(WebElement element, String matcher) {
        List<WebElement> elements = element.findElements(By.tagName("li"));
        return elements.stream().filter(el -> el.getText().contains(matcher)).toList().get(0);
    }
}

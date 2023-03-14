package Tests;

import PageObjects.TravellersHomePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

@Slf4j
public class SearchingTest extends BaseTest {
    @ParameterizedTest
    @DisplayName("Searching hotel test")
    @CsvFileSource(resources = "/searchingData.csv")
    public void searchHotel(String cityName, String checkInDate, String checkOutDate, int adultNumber, int kidsNumber) {
        log.info("Start searching hotel test for:\n" +
                "City: " + cityName + "\n" +
                "Check-in date: " + checkInDate + "\n" +
                "Check-out date: " + checkOutDate + "\n" +
                "Adults number: " + adultNumber + "\n" +
                "Kids number: " + kidsNumber);
        List<String> hotelNames = new TravellersHomePage(driver)
                .searchCity(cityName)
                .enterCheckDates(checkInDate, checkOutDate)
                .enterGuestNumber(adultNumber, kidsNumber)
                .searchButtonClick()
                .getHotelNames();
        Assertions.assertTrue(hotelNames.size() > 0);
    }
}

package service;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.BookingMainPage;
import pages.BookingSearchResultsPage;

import java.util.ArrayList;

public class BookingService extends BaseService {

    private String city;
    private String hotel;
    private static final String BOOKING_MAIN_PAGE_URL = "https://www.booking.com/";
    private BookingMainPage bookingMainPage = new BookingMainPage();
    private BookingSearchResultsPage bookingSearchResultsPage = new BookingSearchResultsPage();

    @Given("User is looking for hotel in {string} city")
    public void userIsLookingForHotelInLondon(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        bookingMainPage.openBookingMainPage(BOOKING_MAIN_PAGE_URL);
        bookingMainPage.enterSearchCriteria(city);
        bookingMainPage.clickSearchButton();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelShouldBeOnThePage(String hotel) {
        this.hotel = hotel;
        Assert.assertTrue(isHotelOnPage(hotel));
    }

    @Then("Hotel {string} should be on the first page And rating is {string}")
    public void hotelShouldBeOnTheFirstPageAndRatingIs(String hotel, String hotelRating) {
        SelenideElement hotelScoreRatingElement = bookingSearchResultsPage.getHotelReviewScoreByHotelElement(hotel);
        String actualRating = hotelScoreRatingElement.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isHotelOnPage(hotel), "Hotel not found on the page");
        softAssert.assertEquals(actualRating, hotelRating, "Rating doesn't match");
        softAssert.assertAll();
    }

    @And("Rating is {string}")
    public void ratingIs(String hotelRating) {
        SelenideElement hotelScoreRatingElement = bookingSearchResultsPage.getHotelReviewScoreByHotelElement(hotel);
        String actualRating = hotelScoreRatingElement.getText();
        Assert.assertEquals(actualRating, hotelRating);
    }

    private boolean isHotelOnPage(String hotel) {
        ArrayList<String> hotelNames = new ArrayList<>();
        for (SelenideElement element : bookingSearchResultsPage.getListOfHotelTitleElements()) {
            hotelNames.add(element.getText());
        }
        return hotelNames.contains(hotel);
    }
}

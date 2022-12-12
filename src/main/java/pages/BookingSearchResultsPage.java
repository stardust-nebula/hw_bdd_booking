package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BookingSearchResultsPage {

    private static ElementsCollection listOfHotelTitlesOnPage = $$(By.xpath("//div[@data-testid='title']"));
    private static String hotelReviewScorePath = "//div[@data-testid='title' and text()='%s']/ancestor::div[@data-testid='property-card']//div[contains(@aria-label,'Scored')]";

    public ElementsCollection getListOfHotelTitleElements(){
        return listOfHotelTitlesOnPage;
    }

    public SelenideElement getHotelReviewScoreByHotelElement(String hotel){
        return $(By.xpath(String.format(hotelReviewScorePath, hotel)));
    }



}

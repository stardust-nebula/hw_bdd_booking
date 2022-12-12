package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BookingMainPage {

    private static final SelenideElement INPUT_SEARCH_FIELD = $(By.xpath("//input[@name='ss']"));
    private static final SelenideElement SEARCH_BUTTON = $(By.xpath("//button[@data-sb-id='main' or @type='submit' and not(@data-et-click)]"));

    public BookingMainPage openBookingMainPage(String url){
        open(url);
        return this;
    }

    public BookingMainPage enterSearchCriteria(String searchCriteria){
        INPUT_SEARCH_FIELD.sendKeys(searchCriteria);
        return this;
    }

    public void clickSearchButton(){
        SEARCH_BUTTON.click();
    }
}

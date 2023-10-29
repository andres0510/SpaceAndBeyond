package com.space.and.beyond.test.controller;

import com.space.and.beyond.test.model.dto.CheckoutInfo;
import com.space.and.beyond.test.model.dto.Travel;
import com.space.and.beyond.test.page.CheckoutPage;
import com.space.and.beyond.test.page.CustomizeJourneyPage;
import com.space.and.beyond.test.page.DestinationPage;
import com.space.and.beyond.test.utils.DataUtils;
import com.space.and.beyond.test.utils.Report;
import static com.space.and.beyond.test.utils.dictionary.Message.FAIL;
import static com.space.and.beyond.test.utils.dictionary.Message.SUCCESS;

public class BookingController {

    private BookingController() {}

    public static void enterJourneyCustomization(Travel travel) {
        CustomizeJourneyPage customizeJourneyPage = new CustomizeJourneyPage();
        customizeJourneyPage.selectDepartingDate(travel.getDepartingDate());
        customizeJourneyPage.selectReturningDate(travel.getReturningDate());
        travel.setTotalAdults(Integer.parseInt(customizeJourneyPage.selectAdults()));
        travel.setTotalChilden(Integer.parseInt(customizeJourneyPage.selectChildren()));
        Report.reportInfo(String.format(SUCCESS, "Journey customization done"));
    }

    public static void applyFilter(String filter) {
        DestinationPage destinationPage = new DestinationPage();
        switch (filter) {
            case "launch":
                destinationPage.selectLaunch();
                break;
            case "color":
                destinationPage.selectPlanetColor();
                break;
            default:
                Report.reportFail(String.format(FAIL, "Filter option not valid"));
        }
    }

    public static void selectDestination(Travel travel) {
        DestinationPage destinationPage = new DestinationPage();
        int index;
        String price;
        int destinationsCount = destinationPage.getDestinationsCount();
        if (destinationsCount == 0) {
            Report.reportFail(String.format(FAIL, "There are not options for current select"));
        } else {
            index = DataUtils.getFaker().number().numberBetween(0, destinationsCount-1);
            price = destinationPage.getDestinationPrice(index);
            travel.setDestinationPrice(DataUtils.getPriceAsDouble(price));
            destinationPage.clickBtnBook(index);
        }
    }

    public static void fillCheckoutInformation(CheckoutInfo checkoutInfo) {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.typeName(checkoutInfo.getName());
        checkoutPage.typeEmailAddress(checkoutInfo.getEmail());
        checkoutPage.typeSocialSecurityNumber(checkoutInfo.getSocialSecurityNumber());
        enterPhone(checkoutInfo.getPhoneNumber());
        checkoutPage.enterHealthInsurance(checkoutInfo.getHealthInsurance());
    }

    public static void finishBooking() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.clickAcceptTermsAndConditions();
        checkoutPage.clickBtnPayNow();
    }

    private static void enterPhone(String phoneNumber) {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.typePhoneNumber(DataUtils.getFaker().lorem().word());
        checkoutPage.clickSocialSecurityNumber();
        String errorMessage = checkoutPage.getErrorMessagePhoneNumber();
        String countryCode = DataUtils.getCountryCode(errorMessage);
        String firstDigit = DataUtils.getFirstDigitForPhone(errorMessage);
        String completePhone = String.format("+%s %s%s", countryCode, firstDigit, phoneNumber);
        checkoutPage.typePhoneNumber(completePhone);
    }

}

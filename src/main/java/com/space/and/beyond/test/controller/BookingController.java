package com.space.and.beyond.test.controller;

import com.space.and.beyond.test.model.dto.Travel;
import com.space.and.beyond.test.page.CustomizeJourneyPage;

public class BookingController {

    private BookingController() {}

    public static void enterJourneyCustomization(Travel travel) {
        CustomizeJourneyPage customizeJourneyPage = new CustomizeJourneyPage();
        customizeJourneyPage.selectDepartingDate(travel.getDepartingDate());
        customizeJourneyPage.selectReturningDate(travel.getReturningDate());
        travel.setTotalAdults(Integer.parseInt(customizeJourneyPage.selectAdults()));
        travel.setTotalChilden(Integer.parseInt(customizeJourneyPage.selectChildren()));
    }

    //Todo select destination

}

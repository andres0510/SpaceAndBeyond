package com.space.and.beyond.test.controller;

import com.space.and.beyond.test.model.dto.Travel;
import com.space.and.beyond.test.page.CheckoutPage;
import com.space.and.beyond.test.utils.DataUtils;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertionController {

    private AssertionController() {}

    public static void validateBookingTotalAmount(Travel travel) {
        CheckoutPage checkoutPage = new CheckoutPage();
        double foundAmount = DataUtils.getPriceAsDouble(checkoutPage.getTotalPrice());
        int totalTravelers = travel.getTotalAdults() + travel.getTotalChilden();
        double expectedAmount = travel.getDestinationPrice() * totalTravelers;
        assertThat(foundAmount).isEqualTo(expectedAmount);
    }

    public static void validateStatusCode(int statusCode) {
        assertThat(statusCode).isEqualTo(200);
    }

}

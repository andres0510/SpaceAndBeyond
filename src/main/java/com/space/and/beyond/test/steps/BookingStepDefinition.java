package com.space.and.beyond.test.steps;

import com.space.and.beyond.test.controller.AssertionController;
import com.space.and.beyond.test.controller.BookingController;
import com.space.and.beyond.test.controller.GeneralController;
import com.space.and.beyond.test.controller.LoginController;
import com.space.and.beyond.test.model.dto.Travel;
import com.space.and.beyond.test.model.dto.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingStepDefinition {

    private Travel travel = new Travel();

    @Given("a group of travelers logged on Space and Beyond")
    public void groupOfTravelersLoggedOnSpaceAndBeyond() {
        User user = new User();
        GeneralController.openApp();
        LoginController.logIn(user);
    }

    @When("the journey information is entered")
    public void journeyInformationIsEntered() {
        BookingController.enterJourneyCustomization(travel);
    }

    @And("destination is selected by using {string} filter")
    public void destinationIsSelectedByUsingFilter(String filter){
        BookingController.applyFilter(filter);
        BookingController.selectDestination(travel);
        BookingController.fillCheckoutInformation(travel.getCheckoutInfo());
    }

    @Then("the travel is successfully scheduled")
    public void travelIsSuccessfullyScheduled() {
        AssertionController.validateBookingTotalAmount(travel);
        BookingController.finishBooking();
    }

}

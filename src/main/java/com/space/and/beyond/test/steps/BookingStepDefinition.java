package com.space.and.beyond.test.steps;

import com.space.and.beyond.test.controller.BookingController;
import com.space.and.beyond.test.controller.GeneralController;
import com.space.and.beyond.test.controller.LoginController;
import com.space.and.beyond.test.model.dto.Travel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingStepDefinition {

    private Travel travel;

    @Given("a group of travelers logged on Space and Beyond")
    public void groupOfTravelersLoggedOnSpaceAndBeyond() {
        GeneralController.openApp();
        LoginController.logIn();
    }

    @When("the journey information is entered")
    public void journeyInformationIsEntered() {
        travel = new Travel();
        BookingController.enterJourneyCustomization(travel);
    }
    
    @And("destination is selected by using {string} filter")
    public void destinationIsSelectedByUsingFilter(String filter){
        //Todo
    }

    @Then("the travel is successfully scheduled")
    public void travelIsSuccessfullyScheduled() {
        //Todo
    }

}

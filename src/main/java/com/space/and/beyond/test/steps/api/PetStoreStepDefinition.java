package com.space.and.beyond.test.steps.api;

import com.space.and.beyond.test.controller.AssertionController;
import com.space.and.beyond.test.controller.PetStoreController;
import com.space.and.beyond.test.model.service.Pet;
import com.space.and.beyond.test.utils.DataUtils;
import com.space.and.beyond.test.utils.Report;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetStoreStepDefinition {

    private final Pet pet = DataUtils.getNewPet();
    private int statusCodeAdd;
    private int statusCodeFind;

    @Before
    public static void setUp(){
        Report.init();
    }

    @Given("a new animal in Pet Store")
    public void aNewAnimalInPetStore() {
        statusCodeAdd = PetStoreController.addPet(pet);
    }

    @When("the pet is consulted")
    public void thePetIsConsulted() {
        statusCodeFind = PetStoreController.findPet(pet);
    }

    @Then("it is found")
    public void itIsFound() {
        AssertionController.validateStatusCode(statusCodeAdd);
        AssertionController.validateStatusCode(statusCodeFind);
    }

}

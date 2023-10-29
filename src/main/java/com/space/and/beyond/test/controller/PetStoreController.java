package com.space.and.beyond.test.controller;

import com.space.and.beyond.test.factory.RestAssuredManager;
import com.space.and.beyond.test.model.service.Pet;
import com.space.and.beyond.test.utils.PropertiesFile;
import com.space.and.beyond.test.utils.Report;
import io.restassured.response.ValidatableResponse;
import static com.space.and.beyond.test.utils.dictionary.Message.SUCCESS;
import static com.space.and.beyond.test.utils.dictionary.Path.DEFAULT_PROPERTIES;

public class PetStoreController {

    private static final PropertiesFile propertiesFile = new PropertiesFile(DEFAULT_PROPERTIES);
    private static final String BASE_URI = propertiesFile.getProperty("base.uri");

    private PetStoreController() {
    }

    public static int addPet(Pet pet) {
        String resource = propertiesFile.getProperty("add.pet.resource");
        ValidatableResponse response = RestAssuredManager.callPOST(BASE_URI, resource, pet);
        Report.reportInfo(String.format(SUCCESS, response.extract().body().asString()));
        return response.extract().statusCode();
    }

    public static int findPet(Pet pet) {
        String resource = String.format(propertiesFile.getProperty("find.pet.resource"), pet.getId());
        ValidatableResponse response = RestAssuredManager.callGET(BASE_URI, resource);
        Report.reportInfo(String.format(SUCCESS, response.extract().body().asString()));
        return response.extract().statusCode();
    }

}

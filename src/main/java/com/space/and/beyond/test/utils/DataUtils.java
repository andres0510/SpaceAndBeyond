package com.space.and.beyond.test.utils;

import com.github.javafaker.Faker;
import com.space.and.beyond.test.model.service.Category;
import com.space.and.beyond.test.model.service.Pet;
import com.space.and.beyond.test.model.service.Tag;
import lombok.Getter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static com.space.and.beyond.test.utils.enums.Phone.*;
import static com.space.and.beyond.test.utils.dictionary.Message.FAIL;
import static com.space.and.beyond.test.utils.dictionary.PetInfo.PET_STATUS;

public class DataUtils {

    @Getter
    private static final Faker faker = new Faker();

    public static String generatePhoneNumber() {
        return faker.number().digits(8);
    }

    public static String generateSocialSecurityNumber(){
        final String FORMAT = "%s-%s-%s";
        return String.format(FORMAT, faker.number().digits(3), faker.number().digits(2), faker.number().digits(4));
    }

    public static double getPriceAsDouble(String price) {
        price = price.replace("$", "");
        price = price.replace(",", "");
        price = price.trim();
        return Double.parseDouble(price);
    }

    public static String getCountryCode(String message) {
        String phoneCode = "";
        if (message.contains(COLOMBIA.getCountryCode())) {
            phoneCode = COLOMBIA.getPhoneCode();
        } else if (message.contains(SPAIN.getCountryCode())) {
            phoneCode = SPAIN.getPhoneCode();
        } else {
            Report.reportFail(String.format(FAIL, "Phone code not defined for current country"));
        }
        return phoneCode;
    }

    public static String getFirstDigitForPhone(String message) {
        String [] digits = new String[]{};
        if (message.contains(COLOMBIA.getCountryCode())) {
            digits = COLOMBIA.getInitialDigits();
        } else if (message.contains(SPAIN.getCountryCode())) {
            digits = SPAIN.getInitialDigits();
        } else {
            Report.reportFail(String.format(FAIL, "Initial digits not defined for current country"));
        }
        return digits[faker.number().numberBetween(0, digits.length-1)];
    }

    public static Pet getNewPet() {
        int id = faker.number().numberBetween(11, 20);
        int petStatusIndex = faker.number().numberBetween(0, PET_STATUS.size()-1);
        Category category = new Category();
        Tag tag = new Tag();
        Pet pet = new Pet();
        List<Tag> tags = new ArrayList<>();
        List<String> photoUrls = Collections.singletonList(faker.avatar().image());
        category.setId(id);
        category.setName(faker.animal().name());
        tag.setId(id);
        tag.setName(faker.lorem().word());
        tags.add(tag);
        pet.setId(id);
        pet.setCategory(category);
        pet.setName(faker.name().firstName());
        pet.setPhotoUrls(photoUrls);
        pet.setTags(tags);
        pet.setStatus(PET_STATUS.get(petStatusIndex));
        return pet;
    }

}

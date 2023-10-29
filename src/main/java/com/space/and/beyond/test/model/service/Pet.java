package com.space.and.beyond.test.model.service;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Pet {

    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

}

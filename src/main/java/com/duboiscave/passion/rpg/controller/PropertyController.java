package com.duboiscave.passion.rpg.controller;

import com.duboiscave.passion.rpg.dto.PropertyDto;
import com.duboiscave.passion.rpg.form.PropertyCreateForm;
import com.duboiscave.passion.rpg.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(PropertyController.Routes.ROOT)
public class PropertyController {

    interface Routes {

        String ROOT = "/properties";
    }

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(final PropertyService propertyService){
        this.propertyService = propertyService;
    }

    @PostMapping(Routes.ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyDto createProperty(@RequestBody @Valid final PropertyCreateForm propertyCreateForm){

        return propertyService.createProperty(propertyCreateForm);
    }
}

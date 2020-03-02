package com.duboiscave.passion.rpg.service;

import com.duboiscave.passion.rpg.dto.PropertyDto;
import com.duboiscave.passion.rpg.form.PropertyCreateForm;

public interface PropertyService {

    PropertyDto createProperty(final PropertyCreateForm propertyCreateForm);
}

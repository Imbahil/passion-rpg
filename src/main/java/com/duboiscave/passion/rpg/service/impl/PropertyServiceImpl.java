package com.duboiscave.passion.rpg.service.impl;

import com.duboiscave.passion.rpg.domain.Property;
import com.duboiscave.passion.rpg.domain.Repository.PropertyRepository;
import com.duboiscave.passion.rpg.dto.PropertyDto;
import com.duboiscave.passion.rpg.exception.FoundException;
import com.duboiscave.passion.rpg.form.PropertyCreateForm;
import com.duboiscave.passion.rpg.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.duboiscave.passion.rpg.service.impl.PropertyServiceImpl.ErrorMessages.PROPERTY_PATTERN;

@Service
public class PropertyServiceImpl implements PropertyService {

    interface ErrorMessages {

        String PROPERTY_PATTERN = "Property with code: %s, already exists";

    }

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(final PropertyRepository propertyRepository) {

        this.propertyRepository = propertyRepository;
    }


    @Override
    public PropertyDto createProperty(final PropertyCreateForm propertyCreateForm) throws FoundException {

        if (propertyRepository.findByPropertyCode(propertyCreateForm.getPropertyCode()).isPresent()){
            throw new FoundException(PROPERTY_PATTERN, propertyCreateForm.getPropertyCode());
        }

        final Property property = Property.builder()
                .propertyCode(propertyCreateForm.getPropertyCode())
                .address(propertyCreateForm.getAddress())
                .leased(propertyCreateForm.getLeased())
                .numberOfApartments(propertyCreateForm.getNumberOfApartments())
                .build();

        propertyRepository.save(property);

        return new PropertyDto(property.getUuid());
    }
}

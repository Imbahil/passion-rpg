package com.duboiscave.passion.rpg.service.impl;

import com.duboiscave.passion.rpg.core.JunitTags;
import com.duboiscave.passion.rpg.domain.Property;
import com.duboiscave.passion.rpg.domain.Repository.PropertyRepository;
import com.duboiscave.passion.rpg.dto.PropertyDto;
import com.duboiscave.passion.rpg.exception.FoundException;
import com.duboiscave.passion.rpg.factory.PropertyDataFactory;
import com.duboiscave.passion.rpg.form.PropertyCreateForm;
import info.solidsoft.mockito.java8.api.WithBDDMockito;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@Tag(JunitTags.UNIT)
@ExtendWith(MockitoExtension.class)
class PropertyServiceImplTest implements WithBDDMockito {

    @InjectMocks
    private PropertyServiceImpl propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    @DisplayName("Property Created")
    @Nested
    class CreateProperty {

        @Test
        @DisplayName("Create property if input is valid")
        void shouldCreatePropertyIfInputIsValid() throws FoundException {

            //given
            final Property property = PropertyDataFactory.PropertyObject.complete().build();

            final PropertyCreateForm propertyCreateForm = new PropertyCreateForm(property.getPropertyCode(),
                    property.getLeased(),
                    property.getAddress(),
                    property.getNumberOfApartments());

            given(propertyRepository.save(any(Property.class))).will(invocationOnMock -> invocationOnMock.getArgument(0));

            //when
            final PropertyDto result = propertyService.createProperty(propertyCreateForm);

            //then
            assertThat(result)
                    .isNotNull()
                    .hasNoNullFieldsOrProperties();
        }
    }
}

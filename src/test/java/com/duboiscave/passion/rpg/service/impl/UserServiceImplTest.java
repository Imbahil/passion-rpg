package com.duboiscave.passion.rpg.service.impl;

import com.duboiscave.passion.rpg.core.JunitTags;
import com.duboiscave.passion.rpg.domain.Repository.UserRepository;
import com.duboiscave.passion.rpg.domain.User;
import com.duboiscave.passion.rpg.dto.UserDto;
import com.duboiscave.passion.rpg.factory.PropertyDataFactory;
import com.duboiscave.passion.rpg.form.UserCreateForm;
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
class UserServiceImplTest implements WithBDDMockito {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @DisplayName("Property Created")
    @Nested
    class CreateUser {

        @Test
        @DisplayName("Create property if input is valid")
        void shouldCreatePropertyIfInputIsValid() throws FoundException {

            //given
            final User user = PropertyDataFactory.PropertyObject.complete().build();

            final UserCreateForm userCreateForm = new UserCreateForm(user.getEmail(), user.getName());

            given(userRepository.save(any(User.class))).will(invocationOnMock -> invocationOnMock.getArgument(0));

            //when
            final UserDto result = userService.createUser(userCreateForm);

            //then
            assertThat(result)
                    .isNotNull()
                    .hasNoNullFieldsOrProperties();
        }
    }
}

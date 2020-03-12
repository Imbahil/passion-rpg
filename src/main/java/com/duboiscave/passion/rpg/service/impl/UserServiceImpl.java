package com.duboiscave.passion.rpg.service.impl;

import com.duboiscave.passion.rpg.domain.Repository.UserRepository;
import com.duboiscave.passion.rpg.domain.User;
import com.duboiscave.passion.rpg.dto.UserDto;
import com.duboiscave.passion.rpg.exception.NonUniqueException;
import com.duboiscave.passion.rpg.form.UserCreateForm;
import com.duboiscave.passion.rpg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.duboiscave.passion.rpg.service.impl.UserServiceImpl.ErrorMessages.PROPERTY_PATTERN;

@Service
public class UserServiceImpl implements UserService {

    interface ErrorMessages {

        String PROPERTY_PATTERN = "User with email: %s, already exists";

    }

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(final UserCreateForm userCreateForm) throws RuntimeException {

        if (userRepository.findByEmail(userCreateForm.getEmail()).isPresent()) {
            throw new NonUniqueException(PROPERTY_PATTERN, userCreateForm.getEmail());
        }

        final User user = User.builder()
                .name(userCreateForm.getName())
                .email(userCreateForm.getEmail())
                .build();

        userRepository.save(user);

        return new UserDto(user.getUuid());
    }
}

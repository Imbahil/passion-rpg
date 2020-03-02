package com.duboiscave.passion.rpg.service;

import com.duboiscave.passion.rpg.dto.UserDto;
import com.duboiscave.passion.rpg.form.UserCreateForm;

public interface UserService {

    UserDto createUser(final UserCreateForm userCreateForm);
}

package com.duboiscave.passion.rpg.factory;

import com.duboiscave.passion.rpg.domain.User;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextBoolean;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class PropertyDataFactory {

    private static final int ALPHABETIC_COUNT = 255;
    private static final int ALPHABETIC_CODE_COUNT = 10;

    public static class PropertyObject {

        public static User.UserBuilder complete(){
            return  User.builder()
                    .name(randomAlphabetic(ALPHABETIC_COUNT))
                    .email(randomAlphabetic(ALPHABETIC_CODE_COUNT));
        }
    }
}

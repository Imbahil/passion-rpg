package com.duboiscave.passion.rpg.factory;

import com.duboiscave.passion.rpg.domain.Property;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextBoolean;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class PropertyDataFactory {

    private static final int ALPHABETIC_COUNT = 255;
    private static final int ALPHABETIC_CODE_COUNT = 10;

    public static class PropertyObject {

        public static Property.PropertyBuilder complete(){
            return  Property.builder()
                    .propertyCode(randomAlphabetic(ALPHABETIC_CODE_COUNT))
                    .address(randomAlphabetic(ALPHABETIC_COUNT))
                    .numberOfApartments(nextInt(1, Integer.MAX_VALUE))
                    .leased(nextBoolean());
        }
    }
}

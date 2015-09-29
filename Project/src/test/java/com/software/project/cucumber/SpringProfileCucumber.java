package com.software.project.cucumber;

import java.io.IOException;

import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;

public class SpringProfileCucumber extends Cucumber {
        public SpringProfileCucumber(Class clazz) throws InitializationError, IOException {
            super(clazz);
            System.setProperty("spring.profiles.active", "test");
        }
    }
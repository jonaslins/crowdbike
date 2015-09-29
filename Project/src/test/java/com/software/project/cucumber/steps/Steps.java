package com.software.project.cucumber.steps;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(locations = { "classpath:cucumber.xml" })
@WebAppConfiguration
public abstract class Steps {

}

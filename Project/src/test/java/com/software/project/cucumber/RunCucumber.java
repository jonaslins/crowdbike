package com.software.project.cucumber;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(SpringProfileCucumber.class)
@CucumberOptions(
		glue= { "com.software.project.cucumber" , "cucumber.api.spring" },
		format={"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class RunCucumber {  
	
	   @BeforeClass
	    public static void preparaBase() throws IOException {
	    	MysqlDataSource ds = new MysqlDataSource();
	    	ds.setUrl("jdbc:mysql://localhost:3306/db_test");
	    	ds.setUser("root");
	    	ds.setPassword("root");
	    	JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
	    	Resource resource = new ClassPathResource("/db_test_script.sql");
	    	System.out.println(resource.toString());
	    	JdbcTestUtils.executeSqlScript(jdbcTemplate, resource, false);
	    }
	
}
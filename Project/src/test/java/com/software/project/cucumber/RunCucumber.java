package com.software.project.cucumber;

import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.software.project.cucumber", "cucumber.api.spring" }, format = { "pretty",
		"html:target/cucumber", "json:target/cucumber.json" })
public class RunCucumber {

	@BeforeClass
	public static void preparaBase() throws IOException {

		Resource propertiesResource = new ClassPathResource("/application-test.properties");
		Properties properties = PropertiesLoaderUtils.loadProperties(propertiesResource);
		
		String dataSourceUrl = properties.getProperty("spring.datasource.url");
		String dataSourceUsername = properties.getProperty("spring.datasource.username");
		String dataSourcePassword = properties.getProperty("spring.datasource.password");

		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl(dataSourceUrl);
		ds.setUser(dataSourceUsername);
		ds.setPassword(dataSourcePassword);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		Resource resource = new ClassPathResource("/db_test_script.sql");

		System.out.println(resource.toString());
		JdbcTestUtils.executeSqlScript(jdbcTemplate, resource, false);
	}

}
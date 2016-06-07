package com.devng.template.springboot.controller;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.devng.template.springboot.Application;
import com.jayway.restassured.RestAssured;

/**
 * Integration test for testing the RESTful APIs provided by the {@link UserController}. For easier testing we are going to rely on the Rest
 * Assured framework.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class UserControllerIntegrationTest {

	@Value("${local.server.port}")
	int localServerPort;

	@Before
	public void setUp() {
		RestAssured.port = localServerPort;
	}

	@Test
	public void testIndexWithoutFilter() {
		when().get("/api/v1/users").then().statusCode(HttpStatus.SC_OK).body("lastName", hasItems("Bond", "Power"));
	}

	@Test
	public void testIndexWithLastNameFilter() {
		given().param("lastName", " pow")
				.when()
				.get("/api/v1/users")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("lastName", allOf(hasItem("Power"), not(hasItem("Bond"))));

		given().param("lastName", "BOND")
				.when()
				.get("/api/v1/users")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("lastName", allOf(hasItem("Bond"), not(hasItem("Power"))));
	}

	@Test
	public void testGetById() {
		when().get("/api/v1/users/1").then().statusCode(HttpStatus.SC_OK).body("lastName", is("Power")).body("id", is(1));
	}
}

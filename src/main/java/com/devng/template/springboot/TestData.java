package com.devng.template.springboot;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.devng.template.springboot.jpa.domain.User;
import com.devng.template.springboot.service.UserService;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TestData {

	private static final Logger log = LoggerFactory.getLogger(TestData.class);

	@Autowired
	private UserService userService;

	@PostConstruct
	public void insertTestData() {
		insertTestUsers();
	}

	private void insertTestUsers() {
		log.debug("Inserting test users");
		if (userService.findByEmail("test@devng.com") == null) {
			User testUser1 = new User();
			testUser1.setEmail("test@user.com");
			testUser1.setFirstName("Max");
			testUser1.setLastName("Power");
			try {
				testUser1.setBirthday(DateUtils.parseDate("12/12/1980", new String[] { "dd/MM/yyyy" }));
			} catch (ParseException e) {
				// ignoring
			}

			userService.saveUser(testUser1);
		}

		if (userService.findByEmail("test2@user.com") == null) {
			User testUser2 = new User();
			testUser2.setEmail("test2@user.com");
			testUser2.setFirstName("James");
			testUser2.setLastName("Bond");
			try {
				testUser2.setBirthday(DateUtils.parseDate("12/12/1985", new String[] { "dd/MM/yyyy" }));
			} catch (ParseException e) {
				// ignoring
			}

			userService.saveUser(testUser2);
		}
	}
}

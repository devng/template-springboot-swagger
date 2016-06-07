package com.devng.template.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devng.template.springboot.jpa.domain.User;
import com.devng.template.springboot.service.UserService;
import com.google.common.base.Strings;
import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/users")
@Api(value = "users", description = "User resource endpoint")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * This controller method index users from the database, the client can provide optional parameter to limit the search such as a last
	 * name.
	 *
	 * @param lastName
	 *            Optional query parameter for indexing users by their last name, if <code>null</code> all users are listed.
	 * @return a list of user objects.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<User> index(@RequestParam(value = "lastName", required = false) String lastName) {
		if (Strings.isNullOrEmpty(lastName)) {
			log.debug("Getting all users");
			return userService.findAll();
		} else {
			log.debug("Searching users by their last name");
			return userService.findByLastName(lastName);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") Long id) {
		return userService.findOne(id);
	}
}

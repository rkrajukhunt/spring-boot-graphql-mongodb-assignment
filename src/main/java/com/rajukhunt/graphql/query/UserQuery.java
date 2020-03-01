package com.rajukhunt.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rajukhunt.graphql.dao.entity.User;
import com.rajukhunt.graphql.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Raju Khunt RK
 *
 */

@Component
public class UserQuery implements GraphQLQueryResolver {

	@Autowired
	private UserService userService;

	public Iterable<User> getUsers() {
		return userService.getAllUsers();
	}

	public Optional<User> getUser(final ObjectId id) {
		return userService.getUser(id);
	}

	public Optional<User> getUserByEmail(final String email) {
		return userService.getUserByEmail(email);
	}
}

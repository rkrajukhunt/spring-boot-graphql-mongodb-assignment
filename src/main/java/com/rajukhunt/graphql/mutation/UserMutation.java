package com.rajukhunt.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.rajukhunt.graphql.dao.entity.User;
import com.rajukhunt.graphql.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author Raju Khunt RK
 *
 */

@Component
public class UserMutation implements GraphQLMutationResolver {

	@Autowired
	private UserService userService;

	public User createUser(final String email, final String password, final String name) {
		return userService.createUser(email, password, name);
	}

	public User updateUser(final ObjectId id, final String email, final String name) {
		return userService.updateUser(id, email, name);
	}

	public String deleteUser(final ObjectId id) {
		return userService.deleteUser(id);
	}
}

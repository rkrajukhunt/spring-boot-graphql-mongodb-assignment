package com.rajukhunt.graphql.dao.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rajukhunt.graphql.dao.entity.User;

/**
 * @author Raju Khunt RK
 *
 */

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, ObjectId> {

	/**
	 * @param email
	 * @return
	 */
	Optional<User> findByEmail(String email);
	
}

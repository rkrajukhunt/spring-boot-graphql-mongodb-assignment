package com.rajukhunt.graphql.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajukhunt.graphql.dao.entity.User;
import com.rajukhunt.graphql.dao.repository.UserRepository;

/**
 * @author Raju Khunt RK
 *
 */

@Service
public class UserService{

    private final UserRepository userRepository ;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository ;
    }

    @Transactional
    public User createUser(final String email,final String password, final String name) {
       return this.userRepository.save(User.builder().email(email).name(name).password(password).build());
    }
    
    @Transactional
    public User updateUser(final ObjectId id, final String email, final String name) {
       Optional<User> user = userRepository.findById(id); 
       if(user.isPresent()) {
    	   user.get().setEmail(email);
    	   user.get().setName(name);
    	   return this.userRepository.save(user.get());
       }else return null;
    }
    
    @Transactional
    public String deleteUser(final ObjectId id) {
       userRepository.deleteById(id);
       return "deleted";
    }

    @Transactional(readOnly = true)
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(final ObjectId id) {
        return this.userRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public Optional<User> getUserByEmail(final String email) {
        return this.userRepository.findByEmail(email);
    }
}

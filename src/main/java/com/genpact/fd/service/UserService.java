package com.genpact.fd.service;

import java.util.List;

import com.genpact.fd.entity.User;

public interface UserService {

	List<User> getAllUsers();

	void saveUser(User user);

	User getUserById(Long id);

	void deleteUserById(Long id);

	
	

}

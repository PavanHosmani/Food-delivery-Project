package com.genpact.fd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.fd.entity.User;
import com.genpact.fd.service.UserService;
import com.genpact.fd.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository UserRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		UserRepository = userRepository;
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return UserRepository.findAll();
	}
	@Override
	public void saveUser(User user) {
		UserRepository.save(user);
		
	}
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return UserRepository.findById(id).get();
	}
	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		UserRepository.deleteById(id);
	}
	
	
}

package com.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.exception.ResourceNotFoundException;
import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User getUserWithId(Long userId) {
		return repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
	}

	@Override
	public User addUser(User newUser) {
		return repo.save(newUser);
	}

	@Override
	public User updateUser(User updateUser,Long userId) {
		User oldUser=null;
		oldUser=repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		oldUser.setFirstName(updateUser.getFirstName());
		oldUser.setLastName(updateUser.getLastName());
		oldUser.setEmail(updateUser.getEmail());
		oldUser.setMobile(updateUser.getMobile());
		return repo.save(oldUser);
	}

	@Override
	public void deleteUser(Long userId) {
		repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		repo.deleteById(userId);
	}

}

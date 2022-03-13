package com.user.service;

import java.util.List;

import com.user.model.User;


public interface UserService {
	
	
	public List<User> getAllUsers();
	public User getUserWithId(Long userId);
	public User addUser(User newUser);
	public User updateUser(User updateUser,Long userId);
	public void deleteUser(Long userId);

}

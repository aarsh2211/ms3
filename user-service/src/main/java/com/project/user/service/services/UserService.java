package com.project.user.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.service.entity.User;
import com.project.user.service.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	public User saveUser(User user) {
		return repo.save(user);
	}
}

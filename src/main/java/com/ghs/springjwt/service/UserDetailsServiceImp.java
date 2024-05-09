package com.ghs.springjwt.service;

import org.springframework.stereotype.Service;

import com.ghs.springjwt.repository.UserRepository;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Data
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Could not find any user with the name "+username));
	}

}

package com.JadwalBus.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.JadwalBus.Model.PenumpangModel;
import com.JadwalBus.Repository.PenumpangRepository;

@Service
public class JwtPenumpangDetailService implements UserDetailsService {
	
	@Autowired
	PenumpangRepository penumpangRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		PenumpangModel penumpang = penumpangRepo.findByUsername(username);
		return new User(penumpang.getUsername(), penumpang.getPassword(),
				new ArrayList<>());
	}
	

}

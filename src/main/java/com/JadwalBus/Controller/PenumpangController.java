package com.JadwalBus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JadwalBus.Config.JwtTokenUtil;
import com.JadwalBus.Model.PenumpangModel;
import com.JadwalBus.Repository.PenumpangRepository;
import com.JadwalBus.Service.JwtPenumpangDetailService;

@RestController
@RequestMapping("/penumpang")
public class PenumpangController {
	
	@Autowired
	PenumpangRepository penumpangRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	JwtPenumpangDetailService jwtPenumpangDetailService;
	
	
	
	@GetMapping("/")
	private List<PenumpangModel> insertBus(@RequestBody PenumpangModel penumpang) {
//		penumpangRepo.save(penumpang);
		return penumpangRepo.findAll();
	}
	
	@PostMapping("/registrasi")
	private ResponseEntity<String> savePenumpang(
			@RequestBody PenumpangModel penumpang) {
		penumpang.setPassword(passwordEncoder.encode(penumpang.getPassword()));
		penumpangRepo.save(penumpang);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Berhasil dibuat");
	}
	
	
	@PostMapping("/login")
	private ResponseEntity<?> login(@RequestBody PenumpangModel penumpangModel) throws Exception {
		authenticate(penumpangModel.getUsername(),penumpangModel.getPassword());
		
		final UserDetails userDetails = jwtPenumpangDetailService
				.loadUserByUsername(penumpangModel.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			// user disable
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			// invalid credentials
			throw new Exception("INVALID_CREDENTIALS", e);
		}

	}
	
	
	
	
	
	
	
}

package com.JadwalBus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JadwalBus.Model.KeberangkatanModel;
import com.JadwalBus.Repository.KeberangkatanRepository;

@RestController
@RequestMapping("/keberangkatan")
public class KeberangkatanController {
	
	@Autowired
	KeberangkatanRepository keberangkatanRepo;
	
	@PostMapping("/insertKeberangkatan")
	private List<KeberangkatanModel> insertKeberangkatan(
			@RequestBody KeberangkatanModel keberangkatan) {
		keberangkatanRepo.save(keberangkatan);
		return keberangkatanRepo.findAll();
	}

}

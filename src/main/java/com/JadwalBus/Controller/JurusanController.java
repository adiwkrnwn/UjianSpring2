package com.JadwalBus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JadwalBus.Model.JurusanModel;
import com.JadwalBus.Repository.JurusanRepository;

@RestController
@RequestMapping("/jurusan")
public class JurusanController {
	
	@Autowired
	JurusanRepository jurusanRepo;
	
	@PostMapping("/insertJurusan")
	private List<JurusanModel> insertJurusan(
			@RequestBody JurusanModel jurusan) {
		jurusanRepo.save(jurusan);
		return jurusanRepo.findAll();
	}

}

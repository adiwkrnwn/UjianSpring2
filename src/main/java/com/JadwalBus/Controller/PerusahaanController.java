package com.JadwalBus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JadwalBus.Model.PerusahaanModel;
import com.JadwalBus.Repository.PerusahaanRepository;

@RestController
@RequestMapping("/perusahaan")
public class PerusahaanController {
	
	@Autowired
	PerusahaanRepository perusahaanRepo;
	
	@PostMapping("/insertPerusahaan")
	private List<PerusahaanModel> insertPerusahaan(
			@RequestBody List<PerusahaanModel> perusahaan) {
		perusahaanRepo.saveAll(perusahaan);
		return perusahaanRepo.findAll();
	}

}

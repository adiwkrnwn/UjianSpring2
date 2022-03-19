package com.JadwalBus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JadwalBus.Model.BookingModel;
import com.JadwalBus.Model.BusCustomeKeberangkatan;
import com.JadwalBus.Model.BusModel;
import com.JadwalBus.Model.PenumpangModel;
import com.JadwalBus.Repository.BookingRepository;
import com.JadwalBus.Repository.BusRepository;
import com.JadwalBus.Repository.KeberangkatanRepository;
import com.JadwalBus.Repository.PenumpangRepository;

@RestController
@RequestMapping("/busbookingsystem")
public class BusController {
	
	@Autowired
	BusRepository busRepo;
	
	@Autowired
	PenumpangRepository penumpangRepo;
	
	@Autowired
	KeberangkatanRepository keberangkatanRepo;
	
	@Autowired
	BookingRepository bookingRepo;
	
	
	@PostMapping("/insertBus")
	private String insertBus(@RequestBody List<BusModel> bus) {
		busRepo.saveAll(bus);
		return "berhasil ditambahkan";
	}
	
	@PostMapping("/insertPenumpang")
	private String insertPenumpang(@RequestBody List<PenumpangModel> penumpang) {
		penumpangRepo.saveAll(penumpang);
		return "Data penumpang berhasil ditambahkan";
	}
	
	@GetMapping("/getPenumpang/{nik}")
	private String cekPenumpang(
			@PathVariable(value="nik") String nik,
			@RequestBody PenumpangModel penumpang) {
		if (nik.equals(penumpang.getNik()) ) {
			return "Penumpang telah terdaftar";
		} else {	
			return "Penumpang belum terdaftar, silakan buat akun.";
		}
		
	}
	
	
	@GetMapping("/keberangkatan")
	private List<BusCustomeKeberangkatan> getAllDatakeberangkatan() {
		return keberangkatanRepo.getAlldataKeberangkatan();
	}
	
	@GetMapping("/findKeberangkatan")
	private List<BusCustomeKeberangkatan> getDataKeberangkatan(
			@RequestParam(name="terminal") String terminal,
			@RequestParam(name="tanggal") String tanggal) {
		return keberangkatanRepo.getDataKeberangkatan(terminal, tanggal);
	}
	 
	@PostMapping("/booking")
	private String insertBooking (
			@RequestBody BookingModel booking) {
		bookingRepo.save(booking);
		return "Pemesanan bus berhasil";
	}
	
	
	@PostMapping("/cancel")
	private String cancelBooking (
			@RequestParam(name="id") long id) {
		bookingRepo.deleteById(id);
		return "Pemesanan dengan nomor " + id + " telah dibatalkan";
	}
	

}

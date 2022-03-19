package com.JadwalBus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JadwalBus.Model.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
	
	

}

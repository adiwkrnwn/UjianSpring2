package com.JadwalBus.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.JadwalBus.Model.BusModel;

public interface BusRepository extends JpaRepository<BusModel, String> {


	
}

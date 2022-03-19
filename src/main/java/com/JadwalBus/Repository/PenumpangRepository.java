package com.JadwalBus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JadwalBus.Model.PenumpangModel;

public interface PenumpangRepository extends JpaRepository<PenumpangModel, String> {

	PenumpangModel findByUsername(String username);


}

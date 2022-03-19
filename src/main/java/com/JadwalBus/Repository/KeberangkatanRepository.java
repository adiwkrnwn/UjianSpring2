package com.JadwalBus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JadwalBus.Model.BusCustomeKeberangkatan;
import com.JadwalBus.Model.KeberangkatanModel;

public interface KeberangkatanRepository extends JpaRepository<KeberangkatanModel, Long> {
	
	@Query(value = "SELECT `keberangkatan`.`id`, `jurusan`.`deskripsi`, `tanggal`, `bus`.`nama_perusahaan`, `kelas`, `harga` FROM `keberangkatan`\r\n"
			+ "INNER JOIN `jurusan` ON `keberangkatan`.`id_jurusan` = `jurusan`.`id`\r\n"
			+ "INNER JOIN `bus` ON `keberangkatan`.`no_polisi` = `bus`.`no_polisi`", nativeQuery = true)
	List<BusCustomeKeberangkatan> getAlldataKeberangkatan();
	
	@Query(value = "SELECT `keberangkatan`.`id`, `bus`.`nama_perusahaan` as `perusahaan`, `kelas`, `harga`,  `tanggal` as `waktu`, `jurusan`.`deskripsi`  FROM `keberangkatan`\r\n"
			+ "INNER JOIN `jurusan` ON `keberangkatan`.`id_jurusan` = `jurusan`.`id`\r\n"
			+ "INNER JOIN `bus` ON `keberangkatan`.`no_polisi` = `bus`.`no_polisi`\r\n"
			+ "WHERE jurusan.terminal_awal = ?1 "
			+ "AND tanggal LIKE ?2% ", nativeQuery = true)
	List<BusCustomeKeberangkatan> getDataKeberangkatan(String terminal, String tanggal);
	

}

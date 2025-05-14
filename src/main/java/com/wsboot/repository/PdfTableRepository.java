package com.wsboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsboot.entity.PdfTable;


@Repository
public interface PdfTableRepository extends JpaRepository<PdfTable, Long> {

	
}

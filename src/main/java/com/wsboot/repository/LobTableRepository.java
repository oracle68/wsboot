package com.wsboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsboot.entity.LobTable;


@Repository
public interface LobTableRepository extends JpaRepository<LobTable, Long> {

	
}

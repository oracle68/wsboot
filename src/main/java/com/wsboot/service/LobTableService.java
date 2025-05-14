package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsboot.entity.LobTable;
import com.wsboot.repository.LobTableRepository;


@Service
public class LobTableService {

	    @Autowired
	    LobTableRepository lDao;

	    public List<LobTable> findAllLobs() {
	        return this.lDao.findAll();
	    }

	    public LobTable addLob(LobTable l) {
	        return this.lDao.save(l);
	    }

	    //other methods go here


	    public LobTable getLById(Long id) {
	        return this.lDao.getOne(id);
	    }

	    public LobTable updateLob(LobTable l) {
	        return this.lDao.save(l);
	    }

	    public void deleteLobById(Long id) {
	        this.lDao.deleteById(id);
	    }

	    public void deleteAllLobs() {
	        this.lDao.deleteAll();
	    }

}
package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsboot.entity.PdfTable;
import com.wsboot.repository.PdfTableRepository;


@Service
public class PdfTableService {

	    @Autowired
	    PdfTableRepository pDao;

	    public List<PdfTable> findAllPdfs() {
	        return this.pDao.findAll();
	    }

	    public PdfTable addPdf(PdfTable p) {
	        return this.pDao.save(p);
	    }

	    //other methods go here


	    public PdfTable getPdfById(Long id) {
	        return this.pDao.getOne(id);
	    }

	    public PdfTable updatePdf(PdfTable p) {
	        return this.pDao.save(p);
	    }

	    public void deletePdfById(Long id) {
	        this.pDao.deleteById(id);
	    }

	    public void deleteAllPdfs() {
	        this.pDao.deleteAll();
	    }

}
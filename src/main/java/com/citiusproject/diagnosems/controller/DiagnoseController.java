package com.citiusproject.diagnosems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiusproject.diagnosems.model.Diagnose;
import com.citiusproject.diagnosems.repository.DiagnoseRepository;
import com.citiusproject.diagnosems.service.DiagnoseService;

@RestController
public class DiagnoseController {

	@Autowired
	private DiagnoseService dService;
	
	@Autowired
	private DiagnoseRepository diagnoseRepo;
	
	@RequestMapping(path="dumpDiagnoseData")
	public void setDataInDb() {
		dService.saveDiagnoseData();
	}
	
	@GetMapping("/code")
    public List<String> getCode() {
        return diagnoseRepo.getCode();
    }
	
	@GetMapping("/data/{message}")
    public List<String> publish(@PathVariable String message) {
        return diagnoseRepo.getDescription(message);
    }
	
	@GetMapping("/{message}")
    public List<Diagnose> getData(@PathVariable String message) {
		List<Diagnose> keyword = diagnoseRepo.getDescriptionByKeyword(message);
        return keyword ;
    }
	
	@GetMapping("/depricated/{message}")
    public List<Diagnose> getDepricatedValue(@PathVariable Boolean message) {
		 List<Diagnose> depricated = diagnoseRepo.getByIsDepricated(message);
        return depricated ;
    }
	
	@GetMapping("/alldata")
    public List<Diagnose> getallData() {
        return diagnoseRepo.getAllData();
    }
	
}

package com.citiusproject.diagnosems.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiusproject.diagnosems.model.Diagnose;
import com.citiusproject.diagnosems.repository.DiagnoseRepository;

@Service
public class DiagnoseService {
    
	@Autowired
	private DiagnoseRepository diagnoseDto;
	
	String line="";
	
	public void saveDiagnoseData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Diagnose_Data.csv"));
			while((line=br.readLine())!=null) {
				String [] data = line.split(",");
				Diagnose d = new Diagnose();
				d.setDiagnose_code(data[0]);
				d.setDiagnose_description(data[1]);
				diagnoseDto.save(d);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getdatausingName() {
		Diagnose di = new Diagnose();
		
	}
}

package com.citiusproject.diagnosems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DiagnoseTable")
public class Diagnose {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false, unique = true)
    private Integer id;
	
	@Column(name = "Diagnose_code")
	private String diagnose_code;
	
	@Column(name = "Description")
	private String diagnose_description;
	
	@Column(name = "IsDeprecated")
	private boolean isDepricated = false;
	
	public Diagnose() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiagnose_code() {
		return diagnose_code;
	}

	public void setDiagnose_code(String diagnose_code) {
		this.diagnose_code = diagnose_code;
	}

	public String getDiagnose_description() {
		return diagnose_description;
	}

	public void setDiagnose_description(String diagnose_description) {
		this.diagnose_description = diagnose_description;
	}

	public boolean isDepricated() {
		return isDepricated;
	}

	public void setDepricated(boolean isDepricated) {
		this.isDepricated = isDepricated;
	}

	public Diagnose(Integer id, String diagnose_code, String diagnose_description, boolean isDepricated) {
		super();
		this.id = id;
		this.diagnose_code = diagnose_code;
		this.diagnose_description = diagnose_description;
		this.isDepricated = isDepricated;
	}

	@Override
	public String toString() {
		return "Diagnose [id=" + id + ", diagnose_code=" + diagnose_code + ", diagnose_description="
				+ diagnose_description + ", isDepricated=" + isDepricated + "]";
	}
	
}

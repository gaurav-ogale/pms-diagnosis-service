package com.citiusproject.diagnosems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiusproject.diagnosems.model.Diagnose;

@Repository
public interface DiagnoseRepository extends JpaRepository<Diagnose, Integer>{
  
	@Query(value="select description from diagnose_table where diagnose_code=?1",nativeQuery = true)
	public List<String> getDescription(String diagnose_code);
	
	@Query(value = "select * from diagnose_table p where lower(p.description) like %?1%" , nativeQuery = true)
	public List<Diagnose> getDescriptionByKeyword(String keyword);
	
	@Query(value = "select * from diagnose_table p where p.is_deprecated = ?1", nativeQuery = true)
	public List<Diagnose> getByIsDepricated(Boolean isDepricated);
	
	@Query(value="select diagnose_code from diagnose_table",nativeQuery = true)
	public List<String> getCode();
	
	@Query(value="select * from diagnose_table LIMIT 2000",nativeQuery = true)
	public List<Diagnose> getAllData();
}

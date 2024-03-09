package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.pojo.Student;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

public interface StudentCrud extends CrudRepository<Student, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "from Student")
	public List<Student> read();
	
	
	@Modifying
	@Transactional
	@Query(value = "update Student set dept=:dept where id=:id")
	public int update(@Param("id")int id,@Param("dept")String dept);

	
	@Modifying
	@Transactional
	@Query(value = "delete from Student where id=:id")
	public int delete(@Param("id")int id);
	
	
}

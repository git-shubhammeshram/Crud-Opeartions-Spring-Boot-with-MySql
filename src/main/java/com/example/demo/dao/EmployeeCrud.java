package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.pojo.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeCrud extends CrudRepository<Employee, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "insert into employee(id,name,address,sallary) values(:id,:name,:address,:sallary)",nativeQuery = true)
	public int insert(@Param("id")int id, @Param("name")String name,@Param("address")String address,@Param("sallary")int sallary);

	@Modifying
	@Transactional
	@Query(value = "delete from employee where id=:id",nativeQuery = true)
	public int delete(@Param("id")int id);
	
	@Modifying
	@Transactional
	@Query(value = "select * from employee",nativeQuery = true)
	public List<Employee> read();
	
	@Modifying
	@Transactional
	@Query(value = "update employee set sallary=:sallary where id=:id",nativeQuery = true)
	public int update(@Param("id")int id,@Param("sallary")int sallary);
}

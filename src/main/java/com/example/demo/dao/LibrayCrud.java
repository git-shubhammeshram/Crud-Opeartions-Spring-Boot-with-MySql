package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.Libray;

public interface LibrayCrud extends CrudRepository<Libray, Integer>{
	
	
	@Override
	public <S extends Libray> S save(S entity);
	@Override
	public Iterable<Libray> findAll();
	@Override
	public Optional<Libray> findById(Integer id);
	@Override
	public void deleteById(Integer id);
	
	
	
	
}

package com.zensar.service;

import java.util.List;

import com.zensar.beans.Emp;

public interface EmpService {
	public int save(Emp p);
	public Emp getEmpById(int id);
	public int update(Emp p);
	public int delete(int id);
	public List<Emp> getEmployees();
	
}

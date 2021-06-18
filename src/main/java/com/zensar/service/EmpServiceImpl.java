package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.Emp;
import com.zensar.dao.EmpDao;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao dao;
	public int save(Emp p) {
		return dao.save(p);
	}

	public Emp getEmpById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmpById(id);
	}

	public int update(Emp p) {
		
		return dao.update(p);
	}

	public int delete(int id) {
		
		return dao.delete(id);
	}

	public List<Emp> getEmployees() {
		
		return dao.getEmployees();
	}

}

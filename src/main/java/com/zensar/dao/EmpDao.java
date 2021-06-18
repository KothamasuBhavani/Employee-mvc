package com.zensar.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zensar.beans.Emp;  
@Repository
public class EmpDao { 
@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Emp p){  
    String sql="insert into Emp(name,salary,designation) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";  
    return template.update(sql);  
}  



public Emp getEmpById(int id) {
	String sql = "select * from Emp where id=?";
	return template.queryForObject(sql, new Object[] { id }, new RowMapper<Emp>() {

		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp e = new Emp();
			e.setName(rs.getString("name"));
			e.setSalary(rs.getFloat("salary"));
			e.setDesignation(rs.getString("designation"));
			return e;
		}

	});
}


/*
 * public Emp getEmpById(int id) { String sql = "select * from Emp where id=?";
 * return template.queryForObject(sql, new Object[] { id }, new
 * BeanPropertyRowMapper<Emp>(Emp.class)); }
 */
public int update(Emp p){  
    String sql="update Emp set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Emp where id="+id+"";  
    return template.update(sql);  
}  

public List<Emp> getEmployees(){  
    return template.query("select * from Emp",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setSalary(rs.getFloat(3));  
            e.setDesignation(rs.getString(4));  
            return e;  
        }  
    });  
}  
}  
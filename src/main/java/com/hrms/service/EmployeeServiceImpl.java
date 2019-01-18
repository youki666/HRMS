package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.EmployeeDao;
import com.hrms.domain.Employee;
@Service  
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired  
	 private EmployeeDao e;

	@Override
	public List<Employee> selectByLimitAndOffset(Integer offset,Integer  limit) {
		
		return e.selectByLimitAndOffset(offset, limit);
	}
	@Override
	public int countEmps() {
		return e.countEmps();
	}
	@Override
	public Employee selectEmployeeById(Integer eid) {
		
		return e.selectEmployeeById(eid);
	}
	@Override
	public Employee selectEmployeeByName(String name) {
		
		return e.selectEmployeeByName(name);
	}
	@Override
	public int addEmp(Employee employee) {
		
		return e.addEmp(employee);
	}
	@Override
	public int updateEmpById(Integer empId, Employee employee) {
		
		return e.updateEmpById(empId, employee);
	}
	@Override
	public int deleteEmpById(Integer empId) {
		
		return e.deleteEmpById(empId);
	}



}

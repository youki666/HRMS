package com.hrms.service;

import java.util.List;

import com.hrms.domain.Employee;

public interface EmployeeService {
	public Employee selectEmployeeById(Integer eid);
	public Employee selectEmployeeByName(String name);
   
	public List<Employee> selectByLimitAndOffset(Integer offset,Integer  limit);
   
   public int countEmps();
   public int addEmp(Employee employee);
   int updateEmpById(Integer empId,  Employee employee);
   int deleteEmpById(Integer empId);
   

}

package com.hrms.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.domain.Employee;
import com.hrms.service.EmployeeService;



public class EmployeeServiceTest extends SpringTestCase {


	@Autowired  
	private EmployeeService es;
	@Test
	public void selectByIdTest() {
		Employee e = es.selectEmployeeById(2);
		System.out.println(e.getEmpName()+"..."+e.getGender());
	}
}

package com.hrms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hrms.domain.Employee;

public interface EmployeeDao {
	
	String TABLE_NAME = "tbl_emp";
    String INSERT_FIELDS = "emp_name, emp_email, gender, department_id";
    String SELECT_FIELDS = "emp_id, " + INSERT_FIELDS;
	public Employee selectEmployeeById( Integer eid);
	public Employee selectEmployeeByName(String name);
	
	//addEmp
	@Insert({"INSERT INTO", TABLE_NAME, "(",INSERT_FIELDS,") " +
            "VALUES(#{empName}, " +
            "#{empEmail}, " +
            "#{gender}, " +
            "#{departmentId})"})
   int addEmp(Employee employee);
	// 分页查询
	List<Employee> selectByLimitAndOffset(@Param("offset") Integer offset,
            @Param("limit") Integer limit);
	//更新
	int updateEmpById(@Param("empId")Integer empId, @Param("employee") Employee employee);
	//查询员工总数
	@Select({"select count(*) from", TABLE_NAME})
    public Integer countEmps();
	//删除
	int deleteEmpById(Integer empId);
}

package com.hrms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hrms.domain.Department;
import com.hrms.domain.Employee;

public interface DepartmentDao {
	 String TABLE_NAME = "tbl_dept";
	    String INSERT_FIELDS = "dept_name, dept_leader";
	    String SELECT_FIELDS = "dept_id as 'deptId', " +
	            "dept_name as 'deptName', " +
	            "dept_leader as 'deptLeader'";
	public int selectDepartmentById(Integer id);
	// 分页查询
	List<Department> getDeptList(@Param("offset") Integer offset,
            @Param("limit") Integer limit);
	//查询部门总数
	
    int countDepts();
    //getDeptById
   // @Select({"SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dept_id=#{deptId}" })
    
    Department getDeptById(@Param("deptId") Integer deptId);
    //查询部门列表
    List<Department> selectDeptList();
    //新增部门
    int addDept(@Param("dept") Department dept);
    
    ////更新
	int updateDeptById(@Param("deptId")Integer deptId, @Param("department") Department department);
    //删除部门
    int deleteDept(Integer deptId);
	
}

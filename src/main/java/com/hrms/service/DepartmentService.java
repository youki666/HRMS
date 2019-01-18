package com.hrms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hrms.domain.Department;

public interface DepartmentService {
	public int selectDepartmentById(Integer id);
	// 分页查询
	List<Department> getDeptList(Integer offset, Integer limit);
	//查询部门总数
	public int countDepts();
	//getDeptById(Integer deptId)
	Department getDeptById(Integer deptId);
	
	//查询部门列表
	List<Department> selectDeptList();
	
	//新增部门
	int addDept(Department dept);
	
	//更新
	int updateDeptById(Integer deptId,  Department department);
	
	//删除
	int deleteDept(Integer deptId);
}

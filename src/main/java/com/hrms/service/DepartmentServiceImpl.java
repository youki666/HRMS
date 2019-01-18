package com.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.DepartmentDao;
import com.hrms.domain.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao d;
	@Override
	public int selectDepartmentById(Integer id) {
		
		return d.selectDepartmentById(id);
	}

	@Override
	public List<Department> getDeptList(Integer offset, Integer limit) {
		
		return d.getDeptList(offset, limit);
	}

	@Override
	public int countDepts() {
		
		return d.countDepts();
	}

	@Override
	public List<Department> selectDeptList() {
		
		return d.selectDeptList();
	}

	@Override
	public int addDept(Department dept) {
		
		return d.addDept(dept);
	}

	@Override
	public int updateDeptById(Integer deptId, Department department) {
		
		return d.updateDeptById(deptId, department);
	}

	@Override
	public int deleteDept(Integer deptId) {
		
		return d.deleteDept(deptId);
	}

	@Override
	public Department getDeptById(Integer deptId) {
		
		return d.getDeptById(deptId);
	}



}

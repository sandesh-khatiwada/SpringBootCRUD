package com.sandesh.initial.service;

import com.sandesh.initial.entity.Department;
import com.sandesh.initial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department findDepartmentByName(String departmentName);

}

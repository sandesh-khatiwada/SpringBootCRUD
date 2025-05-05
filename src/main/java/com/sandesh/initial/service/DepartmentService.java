package com.sandesh.initial.service;

import com.sandesh.initial.entity.Department;
import com.sandesh.initial.error.DepartmentAlreadyExistsException;
import com.sandesh.initial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department) throws DepartmentAlreadyExistsException;

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException;

    public Department findDepartmentByName(String departmentName);

}

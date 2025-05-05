package com.sandesh.initial.service;

import com.sandesh.initial.entity.Department;
import com.sandesh.initial.error.DepartmentAlreadyExistsException;
import com.sandesh.initial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

     Department saveDepartment(Department department) throws DepartmentAlreadyExistsException;

     List<Department> getDepartments();

     Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

     void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

     Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException;

     Department findDepartmentByName(String departmentName);

}

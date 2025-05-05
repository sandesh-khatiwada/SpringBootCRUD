package com.sandesh.initial.service;

import com.sandesh.initial.entity.Department;
import com.sandesh.initial.repository.DepartmentRepository;
import com.sandesh.initial.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(departmentId);

        if(department.isEmpty()){
            throw new DepartmentNotFoundException("Department not available");
        }

        return department.get();
    }
    @Override
    public void deleteDepartmentById(Long departmentId){
       departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department){
        Department DBResult = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            DBResult.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            DBResult.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            DBResult.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(DBResult);


    }

    public Department findDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentName(departmentName);
    }


}


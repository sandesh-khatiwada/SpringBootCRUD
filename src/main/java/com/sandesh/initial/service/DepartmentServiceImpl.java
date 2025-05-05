package com.sandesh.initial.service;

import com.sandesh.initial.entity.Department;
import com.sandesh.initial.error.DepartmentAlreadyExistsException;
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
    public Department saveDepartment(Department department) throws DepartmentAlreadyExistsException {

        if(departmentRepository.findByDepartmentNameIgnoreCase(department.getDepartmentName()) != null){
            throw new DepartmentAlreadyExistsException("Department Already Exists");
        }

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
    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        if(!departmentRepository.existsById(departmentId)){
            throw new DepartmentNotFoundException("Department does not exist");
        }

       departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException {

        Optional<Department> DBResult = departmentRepository.findById(departmentId);

        if(DBResult.isEmpty()){
            throw new DepartmentNotFoundException("Department does not exist");
        }

        Department existngDepartment = DBResult.get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            existngDepartment.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            existngDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            existngDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(existngDepartment);


    }

    public Department findDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}


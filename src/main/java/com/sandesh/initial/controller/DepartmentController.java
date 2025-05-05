package com.sandesh.initial.controller;

import com.sandesh.initial.entity.Department;
import com.sandesh.initial.service.DepartmentService;
import com.sandesh.initial.error.DepartmentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

        @PostMapping("/department")
        public Department saveDepartment(@Valid @RequestBody Department department){
                LOGGER.info("Inside save department controller");
                return departmentService.saveDepartment(department);
        }

        @GetMapping("/departments")
        public List<Department> getDepartments(){
                LOGGER.info("Inside get Departments controller");
            return departmentService.getDepartments();
        }

        @GetMapping("/department/{id}")
        public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
            LOGGER.info("Inside get department by id controller");
            return departmentService.getDepartmentById(departmentId);
        }

        @DeleteMapping("/department/{id}")
        public String deleteDepartmentById(@PathVariable("id") Long departmentId){
                LOGGER.info("Inside delete department by id controller");

                departmentService.deleteDepartmentById(departmentId);
                 return "Department Deleted Succesfully";
        }

        @PutMapping("/department/{id}")
        public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
                return departmentService.updateDepartmentById(departmentId,department);
        }

        @GetMapping("/department/name/{name}")
        public Department findDepartmentByName(@PathVariable("name") String departmentName){
                return departmentService.findDepartmentByName(departmentName);
        }
}

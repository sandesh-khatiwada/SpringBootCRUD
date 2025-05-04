package com.sandesh.initial.controller;

import com.sandesh.initial.entity.Department;
import com.sandesh.initial.service.DepartmentService;
import com.sandesh.initial.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        @PostMapping("/department")
        public Department saveDepartment(@RequestBody Department department){
                return departmentService.saveDepartment(department);
        }

        @GetMapping("/departments")
        public List<Department> getDepartments(){
            return departmentService.getDepartments();
        }

        @GetMapping("/department/{id}")
        public Department getDepartmentById(@PathVariable("id") Long departmentId){

            return departmentService.getDepartmentById(departmentId);
        }

        @DeleteMapping("/department/{id}")
        public String deleteDepartmentById(@PathVariable("id") Long departmentId){
                 departmentService.deleteDepartmentById(departmentId);
                 return "Department Deleted Succesfully";
        }

        @PutMapping("/department/{id}")
        public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
                return departmentService.updateDepartmentById(departmentId,department);
        }
}

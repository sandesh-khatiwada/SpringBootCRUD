package com.sandesh.initial.service;

import com.sandesh.initial.entity.Department;
import com.sandesh.initial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                                .departmentId(1)
                                .departmentName("IT")
                                .departmentAddress("Address")
                                .departmentCode("IT001")
                                .build();

        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get department result based on valid department name")
    public void whenValidDepartmentName_DepartmentShouldReturn(){
        String departmentName="IT";
        Department result = departmentService.findDepartmentByName(departmentName);
        assertEquals(departmentName,result.getDepartmentName());
    }

    @Test
    @DisplayName("No result if department name is invalid")
    public void whenInvalidDepartmentName_DepartmentShouldNotReturn(){
        String departmentName="Non existent";
        Department result = departmentService.findDepartmentByName(departmentName);
        assertNull(result);
    }


}
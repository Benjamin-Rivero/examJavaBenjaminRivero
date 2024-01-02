package com.example.poec.main;

import com.example.poec.entity.Department;
import com.example.poec.entity.Region;
import com.example.poec.repository.DepartmentRepository;
import com.example.poec.repository.RegionRepository;

import java.util.List;

public class MainDepartment {

    public static void main(String[] args){
        DepartmentRepository departmentRepository = DepartmentRepository.getInstance();
        Region region = RegionRepository.getInstance().findOneBy("id",1);
        List<Department> departments = departmentRepository.findDepartmentsByRegion(region);
        //departments.forEach(System.out::println);
        Department department = departments.get(0);
        System.out.println("Population dans "+department.getName()+" : "+departmentRepository.findPopulationByDepartment(departments.get(0)));
    }

}

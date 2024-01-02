package com.example.poec.main;

import com.example.poec.entity.Department;
import com.example.poec.entity.Region;
import com.example.poec.repository.CityRepository;
import com.example.poec.repository.DepartmentRepository;
import com.example.poec.repository.RegionRepository;

public class MainCity {

    public static void main(String[] args){
        CityRepository cityRepository = CityRepository.getInstance();
        Department department = DepartmentRepository.getInstance().findOneBy("id",1);
        cityRepository.findCitiesByDepartment(department).forEach(System.out::println);
    }

}

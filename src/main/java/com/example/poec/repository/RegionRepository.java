package com.example.poec.repository;

import com.example.poec.entity.City;
import com.example.poec.entity.Department;
import com.example.poec.entity.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionRepository extends AbstractRepository<Region> {


    private static RegionRepository instance;
    private RegionRepository(){
        super("region");
    }

    public static RegionRepository getInstance(){
        if(instance==null){
            instance = new RegionRepository();
        }
        return instance;
    }


    @Override
    protected Region update(Region object) {
        return null;
    }

    @Override
    protected Region insert(Region object) {
        return null;
    }

    @Override
    protected Region getObject(ResultSet rs) {
        Region region = new Region();
        try {
            region.setId(rs.getLong("id"));
            region.setCode(rs.getString("code"));
            region.setName(rs.getString("name"));
        } catch (SQLException e) {
            System.out.println("Problem attributing data values in RegionRepository : "+e.getMessage());
        }
        return region;
    }

    public int findPopulationByRegion(Region region){
        DepartmentRepository departmentRepository = DepartmentRepository.getInstance();
        int population_totale = 0;
        List<Department> departments = departmentRepository.findDepartmentsByRegion(region);
        for(Department d : departments){
            population_totale+= departmentRepository.findPopulationByDepartment(d);
        }
        return population_totale;
    }

    public List<City> findCitiesByRegion(Region region){
        List<City> cities = new ArrayList<>();
        CityRepository cityRepository = CityRepository.getInstance();
        DepartmentRepository departmentRepository = DepartmentRepository.getInstance();
        List<Department> departments = departmentRepository.findDepartmentsByRegion(region);
        for(Department d : departments){
            cities.addAll(cityRepository.findCitiesByDepartment(d));
        }
        return cities;
    }

}

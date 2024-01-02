package com.example.poec.repository;

import com.example.poec.entity.City;
import com.example.poec.entity.Department;
import com.example.poec.entity.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentRepository extends AbstractRepository<Department> {

    private static DepartmentRepository instance;

    private DepartmentRepository(){
        super("department");
    }

    public static DepartmentRepository getInstance(){
        if(instance==null){
            instance= new DepartmentRepository();
        }
        return instance;
    }
    @Override
    protected Department update(Department object) {
        return null;
    }

    @Override
    protected Department insert(Department object) {
        return null;
    }

    @Override
    protected Department getObject(ResultSet rs) {
        Department department = new Department();
        try {
            department.setId(rs.getLong("id"));
            department.setCode(rs.getString("code"));
            department.setName(rs.getString("name"));
        } catch (SQLException e) {
            System.out.println("Problem attributing data values in Department : "+e.getMessage());
        }
        return department;
    }

    public List<Department> findDepartmentsByRegion(Region region){
        Map<String,Object> fields = new HashMap<>();
        fields.put("region_id",region.getId());
        List<Department> departments = findBy(fields,null,null);
        return departments;
    }

    public int findPopulationByDepartment(Department department){
        int population_totale=0;
        List<City> cities = CityRepository.getInstance().findCitiesByDepartment(department);
        for(City c : cities){
            population_totale+=c.getPopulation();
        }
        return population_totale;
    }
}

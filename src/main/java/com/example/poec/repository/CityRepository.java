package com.example.poec.repository;

import com.example.poec.entity.City;
import com.example.poec.entity.Department;
import com.example.poec.entity.PostalCode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityRepository extends AbstractRepository<City>{

    private static CityRepository instance;
    private CityRepository(){super("city");}

    public static CityRepository getInstance(){
        if(instance==null){
            instance = new CityRepository();
        }
        return instance;
    }
    @Override
    protected City update(City object) {
        return null;
    }

    @Override
    protected City insert(City object) {
        return null;
    }

    @Override
    protected City getObject(ResultSet rs) {
        City city = new City();
        try {
            city.setId(rs.getLong("id"));
            Map<String,Object> fields = new HashMap<>();
            fields.put("city_id",city.getId());
            List<PostalCode> postalCodes = PostalCodeRepository.getInstance().findBy(fields,null,null);
            city.setPostalCodes(postalCodes);
            city.setSiren(rs.getString("siren"));
            city.setName(rs.getString("name"));
            city.setPopulation(rs.getInt("population"));
        } catch (SQLException e) {
            System.out.println("Problem attributing data values in CityRepository : "+e.getMessage());
        }
        return city;
    }

    public List<City> findCitiesByDepartment(Department department){
        Map<String,Object> fields = new HashMap<>();
        fields.put("department_id",department.getId());
        List<City> cities = findBy(fields,null,null);
        return cities;
    }


}

package com.example.poec.repository;

import com.example.poec.entity.PostalCode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostalCodeRepository extends AbstractRepository<PostalCode> {

    private static PostalCodeRepository instance;

    private PostalCodeRepository(){
        super("postal_code");
    }

    public static PostalCodeRepository getInstance(){
        if(instance==null){
            instance = new PostalCodeRepository();
        }
        return instance;
    }
    @Override
    protected PostalCode update(PostalCode object) {
        return null;
    }

    @Override
    protected PostalCode insert(PostalCode object) {
        return null;
    }

    @Override
    protected PostalCode getObject(ResultSet rs) {
        PostalCode postalCode = new PostalCode();
        try {
            postalCode.setId(rs.getLong("id"));
            postalCode.setCode(rs.getString("code"));
        } catch (SQLException e) {
            System.out.println("Problem attributing data values in PostalCodeRepository : "+e.getMessage());
        }
        return postalCode;
    }
}

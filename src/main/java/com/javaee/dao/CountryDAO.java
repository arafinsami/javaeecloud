package com.javaee.dao;

import com.javaee.entity.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDAO {
    List<Country> findAll(String search, int offset, int recordPerPage) ;

    void save(Country country) ;

    void update(Country country) ;

    void delete(int id) ;

    Country findById(int id) ;

    int count(String search) ;
}

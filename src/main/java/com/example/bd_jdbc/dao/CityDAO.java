package com.example.bd_jdbc.dao;

import com.example.bd_jdbc.model.City;

import java.util.List;

public interface CityDAO {
    City addCity(City city);

    void deleteCity(City city);

    City updateCity(City city);

    List<City> getAllCities();

    City getCity(int id);
}

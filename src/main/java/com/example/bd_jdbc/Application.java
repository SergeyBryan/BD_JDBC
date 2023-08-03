package com.example.bd_jdbc;

import com.example.bd_jdbc.dao.CityDaoImpl;
import com.example.bd_jdbc.model.City;

public class Application {


    public static void main(String[] args) {
        CityDaoImpl cityDao = new CityDaoImpl();
        City city = new City(10, "Тюмень");
        cityDao.addCity(new City(10, "Тюмень"));
        city.setCityName("Tumen");
        cityDao.updateCity(city);
        System.out.println(cityDao.getAllCities());
        System.out.println(cityDao.getCity(10));
        cityDao.deleteCity(city);
    }


}

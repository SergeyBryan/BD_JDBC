package com.example.bd_jdbc.dao;

import java.util.Objects;

public class City {
    private int cityId;
    private String cityName;


    public City(int id, String cityName) {
        this.cityId = id;
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId && Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + cityId +
                ", city_name='" + cityName + '\'' +
                '}';
    }
}

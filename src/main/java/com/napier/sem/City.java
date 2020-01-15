package com.napier.sem;

public class City {
  private  String id;
  private String Name;
  private String CountryCode;
  private String District;
  private float Population;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public void setPopulation(float population) {
        Population = population;
    }

    public String getName() {
        return Name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getDistrict() {
        return District;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }

    public float getPopulation() {
        return Population;
    }

    public String getId() {
        return id;
    }
}

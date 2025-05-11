package modelo.dao;

import java.util.List;

import modelo.entities.Country;

public interface CountryDao {

	List<Country> findAll();
	Country findById(String countryId);
	int insertOne(Country country);
	int updateOne(Country country);
	int deleteOne(String countryId);
	
	List<Country> findByRegion(int regionId);
	
}

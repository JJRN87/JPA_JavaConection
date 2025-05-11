package modelo.dao;

import java.util.List;

import modelo.entities.Region;

public interface RegionDao {
	
	List<Region> findAll();
	Region findById(int regionId);
	int insertOne(Region region);
	int updateOne(Region region);
	int deleteOne(int regionId);
	
	
}

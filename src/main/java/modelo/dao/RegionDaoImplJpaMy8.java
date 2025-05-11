package modelo.dao;

import java.util.List;

import modelo.entities.Region;

public class RegionDaoImplJpaMy8 extends AbsGenericoDaoJpa 
		implements RegionDao{

	public RegionDaoImplJpaMy8() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> findAll() {
		jpql = "from Region r";
		// Sería así, select * from regions;
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Region findById(int regionId) {
		// TODO Auto-generated method stub
		return em.find(Region.class, regionId);
	}
	
	//Jpa tiene el autocommit a false. es decir en la base de datos, no está
	@Override
	public int insertOne(Region region) {
	//Por tanto tenemos que arrancar la transacción, que es de la siguiente manera para que haga el commit
		
		try {
		tx.begin();
			em.persist(region);
			tx.commit();
		em.persist(region);
		filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}

	@Override
	public int updateOne(Region region) {
		try {
			if (findById(region.getRegionId()) != null){
					tx.begin();
					em.merge(region);
					tx.commit();
					filas = 1;
			}else
				filas =0 ;
		}catch(Exception e) {
			e.printStackTrace();
			filas = 0;
		}
		return filas;
	}

	@Override
	public int deleteOne(int regionId) {
		Region region = findById(regionId);
		
		try {
			if (region != null){
					tx.begin();
					em.remove(region);
					tx.commit();
					filas = 1;
			}else
				filas =0 ;
		}catch(Exception e) {
			e.printStackTrace();
			filas = -1; //Cuidado, es el caso en que pones -1 si casca.
		}
		return filas;
	}
}

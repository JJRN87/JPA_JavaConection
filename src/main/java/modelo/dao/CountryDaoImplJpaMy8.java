package modelo.dao;

import java.util.List;

import modelo.entities.Country;

public class CountryDaoImplJpaMy8 extends AbsGenericoDaoJpa 
									implements CountryDao {

		public CountryDaoImplJpaMy8() {
			super();
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Country> findAll() {
			jpql = "from Country c";
			query = em.createQuery(jpql);
			
			return query.getResultList();
		}

		@Override
		public Country findById(String countryId) {
			// TODO Auto-generated method stub
			return em.find(Country.class, countryId);
		}

		@Override
		public int insertOne(Country country) {
			try {
				tx.begin();
					em.persist(country);
					tx.commit();
				em.persist(country);
				filas = 1;
				}catch(Exception e) {
					e.printStackTrace();
					filas = 0;
				}
				return filas;
		}

		@Override
		public int updateOne(Country country) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int deleteOne(String CountryId) {
			// TODO Auto-generated method stub
			return 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Country> findByRegion(int regionId) {
			//Se puede usar cualquier de las formas de abajo el jpql
		//	jpql = "from Country c where c.region.regionId = ?1";
			jpql = "from Country c where c.region.regionId = :reg";
			
			query = em.createQuery(jpql);
		//	query.setParameter(1, regionId);
			query.setParameter("reg", regionId);
			
			return query.getResultList();
		}
}

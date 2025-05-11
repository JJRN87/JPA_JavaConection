package testing.daojpa;

import java.util.List;

import modelo.dao.CountryDao;
import modelo.dao.CountryDaoImplJpaMy8;
import modelo.dao.RegionDao;
import modelo.dao.RegionDaoImplJpaMy8;
import modelo.entities.Country;

public class TestCountryDao {

	private static CountryDao cdao;
	private static RegionDao rdao; //Se importa, para insertar el pais, por lo evidente
	
	static {
		cdao = new CountryDaoImplJpaMy8();
		rdao = new RegionDaoImplJpaMy8(); // Se importa, para insertar pais, por lo evidente.
	}

	public static void main(String[] args) {
		
		// uno();
		//todos();
		//PaisesPorRegion();
		insertOne();
	}
	
	
	
	
	
	private static void insertOne() {
		Country country = new Country("XY", "Nisu", rdao.findById(2));
		//Ojo, tal y como está la BBDD de tomás, admite nulo en la base de datos. PERO no debería.
		
		System.out.println(cdao.insertOne(country));
		
	}
	private static void PaisesPorRegion() {
		
		List<Country> paises = cdao.findByRegion(2);
		
		System.out.println("\n" + paises.get(0).getRegion().getRegionName() + "\n");
		                                // Se puede poner paises.getFirst
		for (Country ele: paises) {
			System.out.println(ele.getCountryName());
		}
		
		
		
	/*	for (Country ele: cdao.findByRegion(2)) {
			System.out.println(ele); La manera de sacarlo "feo
		}*/
	}
	
	
	private static void todos() {
		
		for (Country ele: cdao.findAll()) {
		// System.out.println(ele); de esta manera sacas la lista completa, con región etc
			System.out.println(ele.getCountryName());
		}
	
	}
	
	private static void uno() {
		Country country = cdao.findById("AR");	
		System.out.println(country.getCountryName());
		System.out.println(country.getRegion().getRegionName());
		System.out.println(country);
	}
	
	

}

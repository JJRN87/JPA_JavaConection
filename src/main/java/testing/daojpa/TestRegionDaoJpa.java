package testing.daojpa;

import modelo.dao.RegionDao;
import modelo.dao.RegionDaoImplJpaMy8;
import modelo.entities.Region;

public class TestRegionDaoJpa {
	
	private static RegionDao rdao;
	
	static {
		rdao = new RegionDaoImplJpaMy8();
	}

	public static void main(String[] args) {
		//uno();
		//todos();
		insertar();
		//modificar();
		//eliminar();
		

	}

	public static void eliminar() {
		
		System.out.println(rdao.deleteOne(90)); // Lo borrará sin problemas, se espera un 1
		System.out.println(rdao.deleteOne(191)); // No lo borrará, se espera un 0
		System.out.println(rdao.deleteOne(1)); // Cascará, ya que hay paises con más regiones y devolverá un -1
	}
	
	public static void modificar() {
		Region reg = new Region(90, "Mogollon del sur");
		Region reg2 = new Region(901, "Mogollon del sur");
		System.out.println(rdao.updateOne(reg));
		System.out.println(rdao.updateOne(reg2)); // Es espera que sea 0 ya que no hay 901.
	}
	
	public static void insertar() {
		Region reg = new Region(90, "Alexandra la pibón");
		System.out.println(rdao.insertOne(reg));
	}
	
	
	public static void uno() {
		System.out.println("Region 1: " + rdao.findById(1));
	}
	
	public static void todos() {
		for (Region ele: rdao.findAll()) {
			System.out.println(ele);
		}
	}
}

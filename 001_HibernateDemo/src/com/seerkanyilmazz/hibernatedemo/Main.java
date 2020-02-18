package com.seerkanyilmazz.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//List<City> cities = session.createQuery("from City c where c.countryCode = 'TUR'").getResultList();
			//List<City> cities = session.createQuery("from City c where c.countryCode = 'TUR' OR c.countryCode = 'USA'").getResultList();
			//List<City> cities = session.createQuery("from City c where c.countryCode = 'TUR' AND c.district = 'Ankara'").getResultList();
			//List<City> cities = session.createQuery("from City c where c.name LIKE '%kar%'").getResultList();
			//List<City> cities = session.createQuery("from City c ORDER BY c.name").getResultList();
			//List<City> cities = session.createQuery("from City c Order BY c.name desc").getResultList();
			//List<String> countryCodes = session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList();
						
			/*for (City city : cities) {
				System.out.println(city.getName());
			}*/
			
			/*
			 * for (String countryCode : countryCodes) { System.out.println(countryCode); }
			 */
			
			//INSERT CODE
//			City city = new City();
//			city.setName("Eskisehir 444");
//			city.setCountryCode("TUR");
//			city.setDistrict("Ic Anadolu");
//			city.setPopulation(100000000);
//			session.save(city);
			
			//UPDATE
//			City city = session.get(City.class, 4087);
//			city.setPopulation(444444444);
//			session.save(city);
			
			//DELETE
			City city = session.get(City.class, 4087);
			session.delete(city);
			
			session.getTransaction().commit();
			//System.out.println("City Added...");
			//System.out.println("City Updated...");
			System.out.println("City Deleted");
		}finally {
			factory.close();
		}

	}

}

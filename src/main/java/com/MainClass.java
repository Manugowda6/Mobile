package com;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("killing");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		//		Sim s1 = new Sim();
		//		s1.setOperator("3G");
		//		s1.setType("Airtel");
		//		
		//		Sim s2 = new Sim();
		//		s2.setOperator("4G");
		//		s2.setType("Jio");
		//		
		//		List<Sim> l = new ArrayList<Sim>();
		//		l.add(s1);
		//		l.add(s2);
		//		
		//		Mobile m = new Mobile();
		//		m.setBrand("Redmi");
		//		m.setCost(25000);
		//		m.setSims(l);
		//		
		//		et.begin();
		//		em.persist(s1);
		//		em.persist(s2);
		//		em.persist(m);
		//		et.commit();

		//		Mobile m = em.find(Mobile.class, 1);
		//		System.out.println(m.getBrand());
		//		System.out.println("------------");
		//		
		//		List<Sim> sim=m.getSims();
		//		for(Sim sims:sim) {
		//			System.out.println(sims.getId());
		//			System.out.println(sims.getOperator());
		//			System.out.println(sims.getType());
		//			System.out.println("---------");
		//		}

		Mobile m = em.find(Mobile.class, 3);

		List<Sim> sim=m.getSims();


		et.begin();

		for(Sim sims:sim) {
			em.remove(sims);
		}
		em.remove(m);
		et.commit();


	}
}

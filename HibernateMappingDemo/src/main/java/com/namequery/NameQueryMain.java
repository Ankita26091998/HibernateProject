package com.namequery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NameQueryMain {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		Transaction t = ses.beginTransaction();
//		Lerner l = new Lerner("Ankita", "Hyderabad");
//		Lerner l1 = new Lerner("Shreya", "Pune");
//		Lerner l2 = new Lerner("Pooja", "Mumbai");
//		ses.persist(l);
//		ses.persist(l1);
//		ses.persist(l2);
//		Query query = ses.getNamedQuery("findLearnerbyId");
//		query.setInteger("Id1", 3);

//		Query query = ses.getNamedQuery("findLearnerbyName");

//		Query query = ses.getNamedQuery("findLearnerbyIdDesc");

//		Query query = ses.getNamedQuery("findCitybyName");
//		query.setString("LName", "Shreya");
//		List<Lerner> list = query.list();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("Lid: " + list.get(i).getLernerId());
//			System.out.println("LName: " + list.get(i).getLernerName());
//			System.out.println("LCity: " + list.get(i).getLernerCity());
//		}

//		Query query = ses.createQuery("Select count (lernerCity) from Lerner");
//		Query query = ses.createQuery("delete from Lerner where lernerId=:lId");
//		query.setParameter("lId", 2);
//		int status = query.executeUpdate();
//		System.out.println("Count: " + query.list().get(0));

//		Query query = ses.createQuery("update Lerner set lernerName=:lName where lernerId=:lId ");
//		query.setParameter("lName", "Shivani");
//		query.setParameter("lId", 3);
//		int status = query.executeUpdate();
//
//		System.out.println("status: " + status);

		t.commit();
		ses.close();
	}

}

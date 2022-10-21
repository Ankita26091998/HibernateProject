package com.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainManytoMany {

	public static void main(String[] args) {
		System.out.println("Project Started!");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		Transaction tx = ses.beginTransaction();

		Employee e1 = new Employee();
		e1.setEname("Ankita");
		Employee e2 = new Employee();
		e2.setEname("Shivani");

		List<Employee> eList = new ArrayList<Employee>();
		eList.add(e1);
		eList.add(e2);

		Project p1 = new Project();
		p1.setPname("Albertsons");
		p1.setEmployees(eList);

		Project p2 = new Project();
		p2.setPname("GDP");
		p2.setEmployees(eList);

		List<Project> projects = new ArrayList<Project>();
		projects.add(p1);
		projects.add(p2);

		e1.setProjects(projects);
		e2.setProjects(projects);

		ses.save(e1);
		ses.save(e2);

		ses.save(p1);
		ses.save(p2);
		tx.commit();
		ses.close();
	}

}

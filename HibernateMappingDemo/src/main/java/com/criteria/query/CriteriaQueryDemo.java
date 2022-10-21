package com.criteria.query;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CriteriaQueryDemo {
	private static SessionFactory factory;

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		Transaction tx = ses.beginTransaction();
//
//		Employee e1 = new Employee("Ankita", "Hyderabad", 40000, "ASE");
//		Employee e2 = new Employee("Shreya", "Pune", 50000, "SE");
//		Employee e3 = new Employee("Pooja", "Mumbai", 20000, "TSM");
//		Employee e4 = new Employee("Renu", "Pune", 30000, "TL");
//		
//
//		ses.persist(e1);
//		ses.persist(e2);
//		ses.persist(e3);
//		ses.persist(e4);

		Criteria cr = ses.createCriteria(Employee.class);
//		// Add restriction.
//		cr.add(Restrictions.gt("esalary", 20000));
		List<Employee> employees = cr.list();

		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("Name: " + employee.geteName());
			System.out.println("City: " + employee.getEcity());
			System.out.println("Designation : " + employee.getEdesignation());
			System.out.println("Salary: " + employee.getEsalary());

		}

		// to get count of city with given condition
//		long count = (Long) ses.createCriteria(Employee.class).setProjection(Projections.rowCount())
//				.add(Restrictions.like("ecity", "P%")).uniqueResult();
//		System.out.println("Number of employees with 'P' in city=" + count);

		// get sum of salary
//		cr.setProjection(Projections.sum("esalary"));
//		List tSalary = cr.list();
//
//		System.out.println("Total Salary: " + tSalary.get(0));

		// group by salary
//		cr.setProjection(Projections.groupProperty("ecity"));
//		List cityList = cr.list();
//		System.out.println("Group By: " + cityList);

		tx.commit();
		ses.close();

	}

}

package com.hibernate.jpa.crud.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.jpa.crud.model.Employee;
import com.hibernate.jpa.crud.util.EmployeeUtil;

public class EmployeeDao {
	public void saveEmployee(String name, String city, int sal) {
		Session session = EmployeeUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEname(name);
			employee.setEsalary(sal);
			employee.setEcity(city);

			session.save(employee);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void findEmployeeById(int id) {
		Session session = EmployeeUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Query q = session.createQuery(" from Employee where eid=:id");
			q.setParameter("id", id);
//			q.executeUpdate();
			transaction.commit();
			System.out.println("Records fetch sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public static List<Employee> displayRecords() {
		Session session = EmployeeUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			transaction = session.beginTransaction();
			employeeList = session.createQuery("FROM Employee").list();
			for (Employee e : employeeList) {
				System.out.println(e.getEid() + " " + e.getEname() + " " + e.getEcity() + " " + e.getEsalary());
			}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeList;
	}

	public void updateEmployee(String name, int id) {
		Transaction transaction = null;

		try {
			Session session = EmployeeUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query q = session.createQuery("update Employee set ename=:name where eid=:id");
			q.setParameter("name", name);
			q.setParameter("id", id);
//			Employee employee = new Employee();
//			employee.setEname(name);
////			employee.setEsalary(sal);
////			employee.setEcity(city);

//			session.update(employee);
			int i = q.executeUpdate();
			if (i > 0) {
				System.out.println("Records inserted sucessessfully");

			}
//			System.out.println("Records updated sucessessfully");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}
}

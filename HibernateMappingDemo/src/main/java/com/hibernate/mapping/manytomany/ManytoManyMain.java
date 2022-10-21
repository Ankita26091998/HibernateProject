package com.hibernate.mapping.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoManyMain {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses;
		ses = factory.openSession();
		Transaction t = ses.beginTransaction();
		try {
			Employee e1 = new Employee();
			e1.setEmployeeName("Pooja Shinde");
			Employee e2 = new Employee();
			e2.setEmployeeName("Ankita Khandekar");
			Employee e3 = new Employee();
			e3.setEmployeeName("Apoorva Pande");

			Department d1 = new Department();
			d1.setDeptName("DevOps and Cloud");
			List<Employee> employeeList = new ArrayList<Employee>();
			employeeList.add(e1);
			employeeList.add(e2);
			employeeList.add(e3);

			d1.setEmployeeList(employeeList);

			Employee e4 = new Employee();
			e4.setEmployeeName("Ketki Shinde");
			Employee e5 = new Employee();
			e5.setEmployeeName("Suyasha Mehta");
			Employee e6 = new Employee();
			e6.setEmployeeName("Arpita Deshmukh");

			Department d2 = new Department();
			d2.setDeptName("Core Development");
			List<Employee> employeeList1 = new ArrayList<Employee>();
			employeeList1.add(e4);
			employeeList1.add(e5);
			employeeList1.add(e6);
			d2.setEmployeeList(employeeList1);

			ses.save(d1);
			ses.save(d2);

			for (int i = 0; i < employeeList.size(); i++) {
				System.out.println(employeeList.get(i).getEmployeeId() + " : " + employeeList.get(i).getEmployeeName());

			}
			for (int i = 0; i < employeeList1.size(); i++) {
				System.out
						.println(employeeList1.get(i).getEmployeeId() + " : " + employeeList1.get(i).getEmployeeName());

			}
			System.out.println(d1.getDeptId() + " : " + d1.getDeptName());
			System.out.println(d2.getDeptId() + " : " + d2.getDeptName());

			t.commit();

			ses.close();
			System.out.println("success");

		} catch (Exception e) {

			System.out.println(e);
		}
	}
}

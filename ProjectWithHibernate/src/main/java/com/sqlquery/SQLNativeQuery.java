package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLNativeQuery {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		String st = "select * from student";
		NativeQuery q = s.createSQLQuery(st);
		List<Object[]> list = q.list();
		for (Object[] student : list) {
			System.out.println(Arrays.toString(student));
		}

		s.clear();
		sf.close();
	}

}

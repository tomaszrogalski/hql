package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();

		System.out.println();
		System.out.println("1--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();

		String hql = "FROM UzytkownikDane a where a.pensja=:pensjazmienna";
		Query query = session.createQuery(hql);
		query.setParameter("pensjazmienna", 300);
		List<UzytkownikDane> results = query.list();
		for (UzytkownikDane uzytkownikDane : results) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();
		System.out.println();
		System.out.println("2--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();

		hql = "FROM UzytkownikDane a where a.pensja=:pensjazmienna";
		query = session.createQuery(hql);
		query.setParameter("pensjazmienna", 400);
		results = query.list();
		for (UzytkownikDane uzytkownikDane : results) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("3--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		hql = "SELECT uzytkownik.pensja from UzytkownikDane uzytkownik";
		query = session.createQuery(hql);
		List<Integer> abc = query.list();
		for (Integer integer : abc) {
			System.out.println(integer);
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("4--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		hql = "FROM UzytkownikDane E WHERE E.id > 7 ORDER BY E.userName DESC, E.SurName DESC ";
		query = session.createQuery(hql);
		List<UzytkownikDane> dasbc = query.list();
		for (UzytkownikDane integer : dasbc) {
			System.out.println(integer);
			System.out.println();
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("5--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		hql = "UPDATE UzytkownikDane set pensja = :pensja WHERE userID = :userID";
		query = session.createQuery(hql);
		query.setParameter("pensja", 1000);
		query.setParameter("userID", 8);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		session.getTransaction().commit();
		session.close();
	}
}

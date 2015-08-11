package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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

		System.out.println();
		System.out.println("6--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(UzytkownikDane.class).add(Restrictions.ge("pensja", 100))
				.add(Restrictions.between("id", 7, 8));
		List<UzytkownikDane> resultsss = criteria.list();

		for (UzytkownikDane uzytkownikDane : resultsss) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("8--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		Criteria criteriaaaaaa = session.createCriteria(UzytkownikDane.class).add(Restrictions.ge("pensja", 100))
				.add(Restrictions.between("id", 7, 8));
		List<UzytkownikDane> resultssasds = criteriaaaaaa.list();

		for (UzytkownikDane uzytkownikDane : resultssasds) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("7--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		Criteria criteria11 = session.createCriteria(UzytkownikDane.class).add(Restrictions.isNotNull("id"));
		List<UzytkownikDane> ASa = criteria11.list();

		for (UzytkownikDane uzytkownikDane : ASa) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("8--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		Criteria criteria1sda1 = session.createCriteria(UzytkownikDane.class).add(Restrictions.isNotNull("id"));
		criteria1sda1.setMaxResults(1);
		criteria1sda1.setFirstResult(2);
		List<UzytkownikDane> ASasdas = criteria1sda1.list();

		for (UzytkownikDane uzytkownikDane : ASasdas) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("9--------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		Query query2 = session.getNamedQuery("wszyscy");
		List<UzytkownikDane> ASassadas = query2.list();
		for (UzytkownikDane uzytkownikDane : ASassadas) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("10-------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		Query query23 = session.getNamedQuery("pensja1000");
		List<UzytkownikDane> ASassadasDSAD = query23.list();
		for (UzytkownikDane uzytkownikDane : ASassadasDSAD) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("11-------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		Query queryqwe23 = session.createQuery("from UzytkownikDane ud where ud.id IN (5,6,7,8)");
		List<UzytkownikDane> ASassaDadasDSAD = queryqwe23.list();
		for (UzytkownikDane uzytkownikDane : ASassaDadasDSAD) {
			System.out.println(uzytkownikDane.toString());
		}
		session.getTransaction().commit();

		System.out.println();
		System.out.println("11-------------------------------------------------------------------------------------");
		System.out.println();
		session.beginTransaction();
		Query quedaSDryqwe23 = session.createQuery(
				"from UzytkownikDane ud where ud.id  = (select cart.id from UzytkownikDane cart where cart.pensja=300)");
		List<UzytkownikDane> ASassASDASDaDadasDSasdAD = quedaSDryqwe23.list();
		for (UzytkownikDane uzytkownikDane : ASassASDASDaDadasDSasdAD) {
			System.out.println(uzytkownikDane);
		}
		session.getTransaction().commit();
		session.close();
	}
}

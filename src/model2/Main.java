package model2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.UzytkownikDane;

public class Main {

	public static void main(String[] args) {

		// SmoczyJezdziec SJ1 = new SmoczyJezdziec("Mustafa", "Wielki ale maly",
		// 20, 50, Ranga.AMATOR);
		// SmoczyJezdziec SJ2 = new SmoczyJezdziec("Andrew", "Klawiatura", 60,
		// 25, Ranga.ZAAWANSOWANY);
		// SmoczyJezdziec SJ3 = new SmoczyJezdziec("Edward", "Siekieroreki", 5,
		// 14, Ranga.SREDNIOZAAWANOWANY);
		// SmoczyJezdziec SJ4 = new SmoczyJezdziec("Karol", "SlabyZart", 17, 30,
		// Ranga.SREDNIOZAAWANOWANY);
		//
		// Smok S1 = new Smok("Arnold", 15, SJ2);
		// Smok S2 = new Smok("Albercik", 1, SJ1);
		// Smok S3 = new Smok("Alfabet", 6, SJ3);
		//
		// Bron B1 = new Bron("Tasak", SJ2, TypBron.LUK, StanBron.ZARYSOWANA);
		// Bron B2 = new Bron("Tristolda", SJ3, TypBron.MIECZ,
		// StanBron.NIEUSZKODZONA);

		Query query;
		List<Object> listaObiektow;
		List<String> listaStringow;
		List<Object[]> listaZTablicaObiektow;
		Long odpowiedzTypuLong;
		String odpowiedzTypuString;
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();

		System.out.println("\n1---------------------------------------------------------------------------------\n");
		session.beginTransaction();
		// session.save(SJ1);
		// session.save(SJ2);
		// session.save(SJ3);
		// session.save(SJ4);
		// session.save(S1);
		// session.save(S2);
		// session.save(S3);
		// session.save(B1);
		// session.save(B2);
		session.getTransaction().commit();

		System.out.println("\n2---------------------------------------------------------------------------------\n");
		session.beginTransaction();
		query = session.getNamedQuery("wszyscy_jezdzcy");
		listaObiektow = query.list();
		for (Object object : listaObiektow) {
			System.out.println(object.toString());
			System.out.println();
		}
		session.getTransaction().commit();

		System.out.println("\n3---------------------------------------------------------------------------------\n");
		session.beginTransaction();
		query = session.getNamedQuery("wszyscy_jezdzcy_ze_smokiem");
		listaZTablicaObiektow = query.list();
		for (Object[] object : listaZTablicaObiektow) {
			System.out.println(Arrays.toString(object));
			System.out.println();
		}
		session.getTransaction().commit();

		System.out.println("\n4---------------------------------------------------------------------------------\n");
		session.beginTransaction();
		query = session.getNamedQuery("ci_co_musza_kopytkowac");
		listaZTablicaObiektow = query.list();
		for (Object[] object : listaZTablicaObiektow) {
			System.out.println(Arrays.toString(object));
			System.out.println();
		}
		session.getTransaction().commit();

		System.out.println("\n5---------------------------------------------------------------------------------\n");
		session.beginTransaction();
		query = session.getNamedQuery("ilu_jezdzcow");
		odpowiedzTypuLong = (Long) query.uniqueResult();
		System.out.println(odpowiedzTypuLong);
		session.getTransaction().commit();

		System.out.println("\n6---------------------------------------------------------------------------------\n");
		session.beginTransaction();
		query = session.getNamedQuery("ma_smoka_staruszka");
		odpowiedzTypuString = (String) query.uniqueResult();
		System.out.println(odpowiedzTypuString);
		session.getTransaction().commit();
		session.close();
	}
}

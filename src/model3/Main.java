package model3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Czlowiek Tomek = new Czlowiek("Tomasz", "Z Nazwiskiem");
		Czlowiek Pawel = new Czlowiek("Pawel", "Bez Nazwiska");
		
		Pies Sonia = new Pies("Sonia", Tomek);
		Pies Ares = new Pies("Ares", Pawel);
		
		Tomek.setPies(Sonia);
		Pawel.setPies(Ares);

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			session.save(Tomek);
			session.save(Pawel);

			transaction.commit();
			System.err.println("Udalo sie");

		} catch (RuntimeException e) {

			try {
				transaction.rollback();
				System.err.println(e.getMessage());
				System.err.println("Nie udalo sie - ROLLBACK");

			} catch (RuntimeException rbe) {
				System.err.println("Nawet ROLLBACK sie zepsul");

			} finally {
				session.close();
			}
		}
	}
}

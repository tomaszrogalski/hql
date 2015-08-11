package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UzytkownikDane {

	@Id
	private int userID;
	private String userName;
	private String SurName;
	private String Adres;
	private int pensja;

	public UzytkownikDane() {

	}

	public UzytkownikDane(int userID, String userName, String surName, String adres, int pensja) {
		super();
		this.userID = userID;
		this.userName = userName;
		SurName = surName;
		Adres = adres;
		this.pensja = pensja;
	}

	public String getSurName() {
		return SurName;
	}

	public void setSurName(String surName) {
		SurName = surName;
	}

	public String getAdres() {
		return Adres;
	}

	public void setAdres(String adres) {
		Adres = adres;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {

		return "ID: " + userID + " \n" + "IMIE: " + userName + " \n" + "NAZWISKO: " + SurName + " \n" + "ADRES: "
				+ Adres + " \n" + "PENSJA: " + pensja;
	}

}

// UzytkownikDane dane1 = new UzytkownikDane(7, "imie7", "nazwisko7", "adres7",
// 300);
// UzytkownikDane dane2 = new UzytkownikDane(8, "imie8", "nazwisko8", "adres8",
// 400);
// UzytkownikDane dane3 = new UzytkownikDane(9, "imie9", "nazwisko9", "adres9",
// 500);
//// session.save(dane1);
//// session.save(dane2);
//// session.save(dane3);

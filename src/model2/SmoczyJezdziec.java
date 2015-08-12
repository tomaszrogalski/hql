package model2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({ @NamedQuery(name = "wszyscy_jezdzcy", query = "from SmoczyJezdziec"),
		@NamedQuery(name = "wszyscy_jezdzcy_ze_smokiem", query = "select sj.imie, sj.ranga, s.imie from SmoczyJezdziec sj left join sj.smok s where s.smoczy_jezdziec is not null"),
		@NamedQuery(name = "ci_co_musza_kopytkowac", query = "select sj.imie, sj.ranga, s.imie from SmoczyJezdziec sj left join sj.smok s where s.smoczy_jezdziec is null"),
		@NamedQuery(name = "ilu_jezdzcow", query = "select count(SJ) as iloscJezdzcow from SmoczyJezdziec SJ"),
		@NamedQuery(name = "ma_smoka_staruszka", query = "select sj.imie from SmoczyJezdziec sj right join sj.smok s where s.wiek in (select max(w.wiek) from Smok w)"),
		@NamedQuery(name = "wszyscy_jezdzcy_ze_smokiem_right_join", query = "select sj.imie, sj.ranga, s.imie from SmoczyJezdziec sj right join sj.smok s") })
@Entity
@Table(name = "smoczy_jezdziec", schema = "kraina_smokow")
public class SmoczyJezdziec {

	@Id
	@SequenceGenerator(name = "smoczy_jezdziec_id_seq", sequenceName = "kraina_smokow.smoczy_jezdziec_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "smoczy_jezdziec_id_seq")
	@Column(name = "smoczy_jezdziec_id")
	private Long id;

	@Column(name = "imie")
	private String imie;

	@Column(name = "nazwisko")
	private String nazwisko;

	@Column(name = "wiek")
	private int wiek;

	@Column(name = "rozmiar_buta")
	private int rozmiarButa;

	@Enumerated(EnumType.STRING)
	@Column(name = "ranga")
	private Ranga ranga;

	@OneToOne(mappedBy = "smoczy_jezdziec", cascade = CascadeType.ALL)
	private Smok smok;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bron", joinColumns = @JoinColumn(name = "smoczy_jezdziec_id") , inverseJoinColumns = @JoinColumn(name = "bron_id") )
	private List<Bron> bron;

	public SmoczyJezdziec() {

	}

	public SmoczyJezdziec(String imie, String nazwisko, int wiek, int rozmiarButa, Ranga ranga) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.rozmiarButa = rozmiarButa;
		this.ranga = ranga;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public int getRozmiarButa() {
		return rozmiarButa;
	}

	public void setRozmiarButa(int rozmiarButa) {
		this.rozmiarButa = rozmiarButa;
	}

	public Ranga getRanga() {
		return ranga;
	}

	public void setRanga(Ranga ranga) {
		this.ranga = ranga;
	}

	public Smok getSmok() {
		return smok;
	}

	public void setSmok(Smok smok) {
		this.smok = smok;
	}

	public List<Bron> getBron() {
		return bron;
	}

	public void setBron(List<Bron> bron) {
		this.bron = bron;
	}

	@Override
	public String toString() {

		return "Imie: " + getImie() + "\nNazwisko: " + getNazwisko() + "\nRanga: " + getRanga() + "\nRozmiar Buta: "
				+ getRozmiarButa() + "\nWiek: " + getWiek();
	}
}

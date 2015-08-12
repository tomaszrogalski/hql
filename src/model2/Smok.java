package model2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "smok", schema = "kraina_smokow")
public class Smok {

	@Id
	@SequenceGenerator(name = "smok_id_seq", sequenceName = "kraina_smokow.smok_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "smok_id_seq")
	@Column(name = "smok_id")
	private Long id;

	@Column(name = "imie")
	private String imie;

	@Column(name = "wiek")
	private int wiek;

	// Bo nie moze istniec smok ktory nie ma jezdzca, smok zawsze musi miec
	// jezdzca not null
	@OneToOne
	@JoinColumn(name = "smoczy_jezdziec_id", unique = true, nullable = false)
	private SmoczyJezdziec smoczy_jezdziec;

	public Smok() {
	}

	public Smok(String imie, int wiek, SmoczyJezdziec smoczyJezdziec) {
		super();
		this.imie = imie;
		this.wiek = wiek;
		this.smoczy_jezdziec = smoczyJezdziec;
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

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public SmoczyJezdziec getSmoczyJezdziec() {
		return smoczy_jezdziec;
	}

	public void setSmoczyJezdziec(SmoczyJezdziec smoczyJezdziec) {
		this.smoczy_jezdziec = smoczyJezdziec;
	}

	@Override
	public String toString() {
		return "Imie: " + getImie() + "\nWiek: " + getWiek() + "\nID Jezdzca: " + getSmoczyJezdziec();
	}
}

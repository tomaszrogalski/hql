package model3;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "czlowiek", schema = "kraina_smokow")
public class Czlowiek {

	@Id
	@SequenceGenerator(name = "czlowiek_id_seq", sequenceName = "kraina_smokow.czlowiek_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "czlowiek_id_seq")
	@Column(name = "czlowiek_id")
	private Long id;

	@Column(name = "imie")
	private String imie;

	@Column(name = "nazwisko")
	private String nazwisko;

	@OneToOne(mappedBy = "czlowiek", cascade = CascadeType.ALL)
	private Pies pies;

	public Czlowiek()
	{
		
	}
	public Czlowiek(String imie, String nazwisko) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
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

	public Pies getPies() {
		return pies;
	}

	public void setPies(Pies pies) {
		this.pies = pies;
	}

	@Override
	public String toString() {

		return getImie() + " Imie psa: " + getPies().getImie();

	}

}

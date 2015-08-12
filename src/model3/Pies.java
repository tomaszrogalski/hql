package model3;

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
@Table(name = "pies", schema = "kraina_smokow")
public class Pies {

	@Id
	@SequenceGenerator(name = "pies_id_seq", sequenceName = "kraina_smokow.pies_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pies_id_seq")
	@Column(name = "pies_id")
	private Long id;

	@Column(name = "imie")
	private String imie;

	@OneToOne()
	@JoinColumn(name = "czlowiek_id")
	private Czlowiek czlowiek;

	public Pies(String imie, Czlowiek czlowiek) {
		super();
		this.imie = imie;
		this.czlowiek = czlowiek;
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

	public Czlowiek getCzlowiek() {
		return czlowiek;
	}

	public void setCzlowiek(Czlowiek czlowiek) {
		this.czlowiek = czlowiek;
	}

	public Pies() {
		// TODO Auto-generated constructor stub
	}

}

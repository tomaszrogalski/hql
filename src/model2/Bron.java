package model2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bron", schema = "kraina_smokow")
public class Bron {

	@Id
	@SequenceGenerator(name = "bron_id_seq", sequenceName = "kraina_smokow.bron_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bron_id_seq")
	@Column(name = "bron_id")
	private Long id;

	@Column(name = "nazwa")
	private String nazwa;

	@ManyToOne
	@JoinColumn(name = "smoczy_jezdziec_id")
	private SmoczyJezdziec smoczyJezdziec;

	@Enumerated(EnumType.STRING)
	@Column(name = "typ_bron")
	private TypBron typBron;

	@Enumerated(EnumType.STRING)
	@Column(name = "stan_bron")
	private StanBron stanBron;

	public Bron() {
	}

	public Bron(String nazwa, SmoczyJezdziec smoczyJezdziec, TypBron typBron, StanBron stanBron) {
		super();
		this.nazwa = nazwa;
		this.smoczyJezdziec = smoczyJezdziec;
		this.typBron = typBron;
		this.stanBron = stanBron;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public SmoczyJezdziec getSmoczyJezdziec() {
		return smoczyJezdziec;
	}

	public void setSmoczyJezdziec(SmoczyJezdziec smoczyJezdziec) {
		this.smoczyJezdziec = smoczyJezdziec;
	}

	public TypBron getTypBron() {
		return typBron;
	}

	public void setTypBron(TypBron typBron) {
		this.typBron = typBron;
	}

	public StanBron getStanBron() {
		return stanBron;
	}

	public void setStanBron(StanBron stanBron) {
		this.stanBron = stanBron;
	}

	@Override
	public String toString() {
		return "bron";
	}

	
	
	
}

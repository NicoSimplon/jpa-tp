package dev.banque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entité représentant le type de compte: Assurance Vie
 * 
 * @author Nicolas
 *
 */
@Entity
public class AssuranceVie extends Compte {

	@Column(name = "TAUX")
	private double taux;

	@Column(name = "DATE_FIN")
	private LocalDate dateFin;

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}

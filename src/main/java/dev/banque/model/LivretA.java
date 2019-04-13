package dev.banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entité représentant un type de compte: Livret A
 * 
 * @author Nicolas
 *
 */
@Entity
public class LivretA extends Compte {

	@Column(name = "TAUX")
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}

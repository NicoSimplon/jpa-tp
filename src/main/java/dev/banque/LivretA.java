package dev.banque;

import javax.persistence.Column;

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

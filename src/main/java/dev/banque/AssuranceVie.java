package dev.banque;

import java.time.LocalDate;

public class AssuranceVie extends Compte {

	private double taux;

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

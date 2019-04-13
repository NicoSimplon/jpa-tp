package dev.banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entité représentant un type spécifique d'opération bancaire: Virement
 * 
 * @author Nicolas
 *
 */
@Entity
public class Virement extends Operation {

	@Column(name = "BENEFICIAIRE")
	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}

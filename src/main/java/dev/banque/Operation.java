package dev.banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	Integer id_operation;

	@Column(name = "DATE_OPE")
	LocalDateTime date;

	@Column(name = "MONTANT")
	Double montant;

	@Column(name = "MOTIF")
	String motif;

	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	Compte compte;

	public Integer getId_operation() {
		return id_operation;
	}

	public void setId_operation(Integer id_operation) {
		this.id_operation = id_operation;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
}

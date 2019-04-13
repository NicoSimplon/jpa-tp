package dev.banque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entité représentant un compte bancaire. Ceci correspond à un compte courant.
 * Un même compte peut être associé à plusieurs clients.
 * Chaque compte garde une trace des opérations bancaires qui sont effectuées sur lui.
 * 
 * @author Nicolas
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;

	@ManyToMany(mappedBy = "comptes")
	private List<Clientb> clientbs;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "SOLDE")
	private Double solde;

	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Clientb> getClientbs() {
		return clientbs;
	}

	public void setClientbs(List<Clientb> clientbs) {
		this.clientbs = clientbs;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}

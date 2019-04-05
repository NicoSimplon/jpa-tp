package dev.banque;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banque")
public class Banque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id_banque;
	
	@Column(name = "NOM")
	private String nom;
	
	@OneToMany(mappedBy = "banque")
	private List<Clientb> clientbs;

	public Integer getId_banque() {
		return id_banque;
	}

	public void setId_banque(Integer id_banque) {
		this.id_banque = id_banque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Clientb> getClientbs() {
		return clientbs;
	}

	public void setClientbs(List<Clientb> clientbs) {
		this.clientbs = clientbs;
	}

}

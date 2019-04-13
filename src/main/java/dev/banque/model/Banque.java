package dev.banque.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entité représentant une banque. 
 * Une banque peut avoir un ou plusieurs client(s).
 * 
 * @author Nicolas
 *
 */
@Entity
@Table(name = "banque")
public class Banque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOM")
	private String nom;
	
	@OneToMany(mappedBy = "banque")
	private List<Clientb> clientbs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

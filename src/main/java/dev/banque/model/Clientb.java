package dev.banque.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientb")
public class Clientb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id_clientb;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Column(name = "DATE_NAISSANCE")
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	public Integer getId_clientb() {
		return id_clientb;
	}

	public void setId_clientb(Integer id_clientb) {
		this.id_clientb = id_clientb;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	@ManyToOne
	@JoinColumn(name = "ID_Banque")
	private Banque banque;

	@ManyToMany
	@JoinTable(name = "correspondance", 
		joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID")
	)
	private List<Compte> comptes;

}

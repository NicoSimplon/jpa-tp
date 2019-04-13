package dev.bibliotheque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Modèle de l'entitée Livre
 * 
 * @author Nicolas
 *
 */
@Entity
@Table(name = "livre")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TITRE")
	private String titre;

	@Column(name = "AUTEUR")
	private String auteur;

	@ManyToMany
	@JoinTable(name = "compo",

			joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"), 
			inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")

	)
	List<Emprunt> emprunts;

	public Livre() {
		emprunts = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "id: " + this.getId() + " - titre: " + this.getTitre() + " - auteur: " + this.getAuteur();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}

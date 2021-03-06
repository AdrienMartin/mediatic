package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "adherent_")
public class Adherent {
	public static enum Droit{USER, ADMIN};
	
	@Id
	@SequenceGenerator(name="Adherent_SEQ", sequenceName="Adherent_SEQ", allocationSize=0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Adherent_SEQ")
	private Long id;
	@NotEmpty
	private String identifiant;
	private String motDePasse;
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@NotNull
	private Date dateNaissance;
	@Email
	@NotEmpty
	private String email;
	private String adresse;
	private int codePostal;
	private String ville;
	private Date datePaiementCotisation;
	private int montantCotisation;
	private Boolean aJourCotisation;
	@Enumerated(EnumType.STRING)
	private Droit droit;
	
	@OneToMany(mappedBy="emprunteur")
	private List<Emprunt> emprunts; 
	
	/*public int getNbEmpruntEncours() {
		return nbEmpruntEncours;
	}
	public void setNbEmpruntEncours(int nbEmpruntEncours) {
		this.nbEmpruntEncours = nbEmpruntEncours;
	}
	private int nbEmpruntEncours;*/
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Date getDatePaiementCotisation() {
		return datePaiementCotisation;
	}
	public void setDatePaiementCotisation(Date datePaiementCotisation) {
		this.datePaiementCotisation = datePaiementCotisation;
	}
	public int getMontantCotisation() {
		return montantCotisation;
	}
	public void setMontantCotisation(int montantCotisation) {
		this.montantCotisation = montantCotisation;
	}
	
	public Boolean getaJourCotisation() {
		return aJourCotisation;
	}
	public void setaJourCotisation(Boolean aJourCotisation) {
		this.aJourCotisation = aJourCotisation;
	}
	public Droit getDroit() {
		return droit;
	}
	public void setDroit(Droit droit) {
		this.droit = droit;
	}
	public List<Emprunt> getEmprunt() {
		return emprunts;
	}
	public void setEmprunt(List<Emprunt> emprunt) {
		this.emprunts = emprunt;
	}
	
	@Override
	public String toString() {
		return "Adherent [identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", email=" + email + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}

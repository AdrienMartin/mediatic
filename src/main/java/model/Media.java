package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "media_")
public class Media {
	public static enum TypeMedia{CD, DVD, LIVRE};
	
	@Id
	@GeneratedValue
	private Long id;
	private String titre;
	private String auteur;
	@Enumerated(EnumType.STRING)
	private TypeMedia typeMedia;
	
	@OneToMany(mappedBy="media")
	private List<Emprunt> emprunt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public TypeMedia getTypeMedia() {
		return typeMedia;
	}
	public void setTypeMedia(TypeMedia type) {
		this.typeMedia = type;
	}
	
	@Override
	public String toString() {
		return "Media [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", type=" + typeMedia + "]";
	}
	
	
}

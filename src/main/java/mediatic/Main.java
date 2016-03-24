package mediatic;

import java.util.Date;

import mediatic.dao.AdherentDAO;
import mediatic.dao.EmpruntDAO;
import mediatic.dao.MediaDAO;
import model.Adherent;
import model.Emprunt;
import model.Media;

public class Main {

	public static void main(String[] args) {
	
		AdherentDAO daoAd=AdherentDAO.getInstance();
		MediaDAO daoM=MediaDAO.getInstance();
		EmpruntDAO daoEm=EmpruntDAO.getInstance();
		
		Adherent ad=new Adherent();	
		ad.setNom("atoto");
		ad.setPrenom("btiti");
		ad.setEmail("toto@gmail.com");
		ad.setMotDePasse("mdp");
		ad.setIdentifiant("identtg");
		ad.setDateNaissance(new Date());
		ad.setDroit(Adherent.Droit.USER);
		
		Adherent ad2=new Adherent();
		ad2.setNom("btoto");
		ad2.setPrenom("atiti");
		ad2.setEmail("2toto@gmail.com");
		ad2.setMotDePasse("2mdp");
		ad2.setIdentifiant("2identtg");
		ad2.setDateNaissance(new Date());
		ad2.setDroit(Adherent.Droit.USER);

		Adherent ad3=new Adherent();
		ad3.setNom("ctoto");
		ad3.setPrenom("ctiti");
		ad3.setEmail("3toto@gmail.com");
		ad3.setMotDePasse("3mdp");
		ad3.setIdentifiant("3identtg");
		ad3.setDateNaissance(new Date());
		ad3.setDroit(Adherent.Droit.USER);
		

		ad=daoAd.persist(ad);
		ad2=daoAd.persist(ad2);
		ad3=daoAd.persist(ad3);
		
		
		Media med=new Media();
		med.setTitre("titre");
		med.setAuteur("auteur");
		med.setTypeMedia(Media.TypeMedia.CD);
		daoM.persist(med);
		
		Emprunt emp=new Emprunt();
		emp.setDateEmprunt(new Date());
		emp.setEmprunteur(ad);
		emp.setMedia(med);
		daoEm.persist(emp);
		
		System.out.println("----------------------------------------------------------");
		System.out.println(daoAd.identification("identtg", "mdp"));
		System.out.println("----------------------------------------------------------");
		System.out.println(daoAd.identification("identt", "mdp"));
		System.out.println("----------------------------------------------------------");
		System.out.println(daoAd.recherche("", "", 1));
	}

}

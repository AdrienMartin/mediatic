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
		MediaDAO daoMe=MediaDAO.getInstance();
		EmpruntDAO daoEm=EmpruntDAO.getInstance();
		
		Adherent ad1=new Adherent();	
		ad1.setNom("atoto");
		ad1.setPrenom("btiti");
		ad1.setEmail("1toto@gmail.com");
		ad1.setMotDePasse("1mdp");
		ad1.setIdentifiant("1identtg");
		ad1.setDateNaissance(new Date());
		ad1.setDroit(Adherent.Droit.USER);
		
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
		
		Adherent ad4=new Adherent();
		ad4.setNom("dtoto");
		ad4.setPrenom("dtiti");
		ad4.setEmail("4toto@gmail.com");
		ad4.setMotDePasse("4mdp");
		ad4.setIdentifiant("4identtg");
		ad4.setDateNaissance(new Date());
		ad4.setDroit(Adherent.Droit.ADMIN);
		

		ad1=daoAd.persist(ad1);
		ad2=daoAd.persist(ad2);
		ad3=daoAd.persist(ad3);
		ad4=daoAd.persist(ad4);
		
		
		Media med1=new Media();
		med1.setTitre("1titre");
		med1.setAuteur("1auteur");
		med1.setTypeMedia(Media.TypeMedia.CD);

		Media med2=new Media();
		med2.setTitre("2titre");
		med2.setAuteur("2auteur");
		med2.setTypeMedia(Media.TypeMedia.CD);

		Media med3=new Media();
		med3.setTitre("3titre");
		med3.setAuteur("3auteur");
		med3.setTypeMedia(Media.TypeMedia.CD);
		
		med1=daoMe.persist(med1);
		med2=daoMe.persist(med2);
		med3=daoMe.persist(med3);
		
		Emprunt emp1=new Emprunt();
		emp1.setDateEmprunt(new Date());
		//emp.setDateRetour(new Date());
		emp1.setEmprunteur(ad1);
		emp1.setMedia(med1);
		
		Emprunt emp2=new Emprunt();
		emp2.setDateEmprunt(new Date());
		//emp.setDateRetour(new Date());
		emp2.setEmprunteur(ad4);
		emp2.setMedia(med3);

		emp1=daoEm.persist(emp1);
		emp2=daoEm.persist(emp2);
		
		System.out.println("----------------------------------------------------------");
		System.out.println(daoAd.identification("identtg", "mdp"));
		System.out.println("----------------------------------------------------------");
		System.out.println(daoAd.identification("identt", "mdp"));
		System.out.println("----------------------------------------------------------");
		System.out.println(daoAd.recherche("", "", 10));
		System.out.println("----------------------------------------------------------");
		System.out.println(daoMe.recherche("", "", Media.TypeMedia.CD, 9));
	}

}

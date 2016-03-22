package mediatic.dao;

import java.util.*;
import javax.persistence.*;

import model.Adherent;

public class AdherentDAO extends GenericDAO<Adherent>{
	
	private static AdherentDAO dao;
	
	private  AdherentDAO() {
		
		 super(Adherent.class);
	}
	public static AdherentDAO getInstance(){
		
		if(dao==null){
			
			dao=new AdherentDAO();
		}
		return dao;
	}
	
	public Adherent identification(String identifiant, String mdp){
		
		Adherent adherent=null;
		
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Adherent> q = em.createQuery("Select a From adherent_ a where a.identifiant=:id and a.motDePasse=:mdp",Adherent.class);
	    q.setParameter("id", identifiant);
	    q.setParameter("mdp", mdp);
	    adherent=q.getSingleResult();
	      
		return adherent;
	}
	public List<Adherent> recherche(String identifiant,String nom, int typeTrie){
		
		List<Adherent>adherents=new ArrayList<Adherent>();
		
		String desc="";
		String trie="";
		switch(typeTrie/2){
				
			case 0: trie="identifiant"; break;
			case 2: trie="prenom";break;
			case 3: trie="dateNaissance";break;
			default: trie="nom";
		}
		if((typeTrie%2)==1){
				
			desc="desc";
				
		}
		
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Adherent> q = em.createQuery("Select a From adherent_ a where a.identifiant=:id% and a.nom=%:nom% or a.prenom=%:nom%  order by :trie :desc",Adherent.class);
	    q.setParameter("id", identifiant);
	    q.setParameter("nom", nom);
	    q.setParameter("desc", desc);
	    q.setParameter("trie", trie);
	    
	    adherents=q.getResultList();
	    
	    return adherents;
		
	}
	
	
	
}

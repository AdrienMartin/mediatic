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
		TypedQuery<Adherent> q = em.createQuery("Select a From Adherent a where a.identifiant=:id and a.motDePasse=:mdp",Adherent.class);
	    q.setParameter("id", identifiant);
	    q.setParameter("mdp", mdp);
	    try{
	    	  adherent=q.getSingleResult();
	    }
	    catch(NoResultException e){
	    	adherent=null;
	    }
	      
		return adherent;
	}
	// TODO: etendre la recherche 
	public List<Adherent> recherche(String identifiant,String nom, int typeTrie){
		
		List<Adherent>adherents=new ArrayList<Adherent>();
		
		String desc="";
		String trie="";
		switch(typeTrie/2){
				
			case 0: trie="identifiant"; break;
			case 2: trie="prenom";break;
			case 3: trie="dateNaissance";break;
			case 4: trie="aJourCotisation"; break;
			default: trie="nom";
		}
		if((typeTrie%2)==1){
				
			desc="desc";
				
		}
		
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Adherent> q = em.createQuery("Select a From Adherent a left join fetch a.emprunts b where a.identifiant LIKE :identifiant and (a.nom LIKE :nom or a.prenom LIKE :nom) order by " + trie + " " +desc,Adherent.class);
	    
		q.setParameter("identifiant", identifiant+"%");
	    q.setParameter("nom", "%"+nom+"%");
	    
	    adherents=q.getResultList();
	    
	    return adherents;
		
	}
	

	
}

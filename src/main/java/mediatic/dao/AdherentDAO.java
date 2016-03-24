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
	public List<Object[]> recherche(String identifiant,String nom, int typeTrie){		
		String desc="";
		String trie="";
		switch(typeTrie/2){
				
			case 0: trie="identifiant"; break;
			case 2: trie="prenom";break;
			case 3: trie="dateNaissance";break;
			case 4: trie="aJourCotisation"; break;
			case 5: trie="count(b)"; break;
			default: trie="nom";
		}
		if((typeTrie%2)==1){
				
			desc="desc";
				
		}
		
		EntityManager em = DatabaseHelper.createEntityManager();
		Query q = em.createQuery("Select a, ("
				+ "Select count(b) "
				+ "from b "
				+ "where (b.dateRetour is null or b.dateRetour > now()) "
				+ "and b.emprunteur = a"
				+ ") "
				+ "From Adherent a "
				+ "left join a.emprunts b "
				+ "where a.identifiant LIKE :identifiant "
				+ "and (a.nom LIKE :nom or a.prenom LIKE :nom) "
				+ "group by a "
				+ "order by " + trie + " " +desc);
				
		q.setParameter("identifiant", identifiant+"%");
	    q.setParameter("nom", "%"+nom+"%");
	    
	    List<Object[]> adherentsTemp = q.getResultList();
	    System.out.println(adherentsTemp.get(0)[0]);
	    System.out.println(adherentsTemp.get(0)[1]);
	    System.out.println(adherentsTemp.get(1)[0]);
	    System.out.println(adherentsTemp.get(1)[1]);
	    System.out.println(adherentsTemp.get(2)[0]);
	    System.out.println(adherentsTemp.get(2)[1]);
	    
	    return adherentsTemp;
		
	}
	

	
}

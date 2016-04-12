package mediatic.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Media;


public class MediaDAO extends GenericDAO<Media>{

	private static MediaDAO dao;
	
	private  MediaDAO() {
		
		 super(Media.class);
	}
	public static MediaDAO getInstance(){
		
		if(dao==null){
			
			dao=new MediaDAO();
		}
		return dao;
	}

	public List<Object[]>recherche(String titre, String auteur, Media.TypeMedia typeMedia, int typeTrie){
		
		
		String desc="";
		String trie="";
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		switch(typeTrie/2){
			
			
			case 1: trie="auteur";break;
			case 2: trie="typeMedia";break;
			case 3: trie="date";
			case 4: trie="nomPrenom";
			default: trie="titre";
		}
		if((typeTrie%2)==1){
			
			desc="desc";
			
		}
		Query q = em.createQuery("Select m, "
				+ "("
					+ "Select e.dateRetour as date "
					+ "from e "
					+ "where (e.dateRetour is null or e.dateRetour > now()) "
					+ "and e.media = m"
				+ "), "
				+ "("
					+ "Select concat(a.nom, ' ', a.prenom) as nomPrenom "
					+ "from a "
					+ "where e.emprunteur = a"
				+ ") "
				+ "From Media m "
				+ "left join m.emprunts e "
				+ "left join e.emprunteur a "
				+ "where m.titre Like :titre "
				+ "and m.auteur Like :auteur "
				+ "and m.typeMedia Like :typeMedia "
				+ "order by " + trie + " " + desc);
		
	    q.setParameter("titre", "%" + titre + "%");
	    q.setParameter("auteur", "%" + auteur+ "%");
	    q.setParameter("typeMedia",typeMedia);
	    
	    List<Object[]> mediasTemp = q.getResultList();

	    System.out.println(mediasTemp.size());
	    
	    for(int i = 0; i < mediasTemp.size(); i++)
	    {
	    	for(int j = 0; j < mediasTemp.get(i).length; j++)
	    	{
	    	    System.out.println(mediasTemp.get(i)[j]);
	    	}
	    }
	    
		return mediasTemp;
	}
	

	public List<Object[]> rechercheAdherentEmprunteur(Media media, int typeTrie){		
		String desc="";
		String trie="";
		switch(typeTrie/2){
				
			case 1: trie="prenom";break;
			case 2: trie="dateRetour";break;
			default: trie="nom";
		}
		if((typeTrie%2)==1){
				
			desc="desc";
				
		}
		
		EntityManager em = DatabaseHelper.createEntityManager();
		Query q = em.createQuery("Select a.nom, a.prenom, b.dateRetour "
				+ "From Adherent a "
				+ "join a.emprunts b "
				+ "join b.media m "
				+ "where m.id = :id "
				+ "order by " + trie + " " +desc);
				
		q.setParameter("id", media.getId());
	    
	    List<Object[]> adherentsTemp = q.getResultList();
	    for(int i = 0; i < adherentsTemp.size(); i++)
	    {
	    	for(int j = 0; j < adherentsTemp.get(i).length; j++)
	    	{
	    	    System.out.println(adherentsTemp.get(i)[j]);
	    	}
	    }
	    
	    return adherentsTemp;
		
	}
}

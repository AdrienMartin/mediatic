package mediatic.dao;

import java.util.*;

import javax.persistence.EntityManager;
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
	// TODO: etendre la recherche 
	public List<Object[]>recherche(String titre, String auteur, String typeMedia, int typeTrie){
		
		List<Media>medias=new ArrayList<Media>();
		
		String desc="";
		String trie="";
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		switch(typeTrie/2){
			
			
			case 1: trie="auteur";break;
			case 2: trie="typeMedia";break;
			case 3: trie="";//todo: emprunte par
			case 4: trie="";//todo: date retour
			default: trie="titre";
		}
		if((typeTrie%2)==1){
			
			desc="desc";
			
		}
		TypedQuery<Media> q = em.createQuery("Select m"
				+ "From Media m left join fetch m.emprunts e"
				+ "where m.titre=:titre "
				+ "and a.auteur=:auteur "
				+ "and a.typeMedia=:typeMedia "
				+ "order by " + trie + " " + desc,Media.class);
		
	    q.setParameter("titre", "%" + titre + "%");
	    q.setParameter("auteur", "%" + auteur+ "%");
	    q.setParameter("typeMedia",typeMedia);
	    
	    medias=q.getResultList();
	    
		return medias;
	}
	


}

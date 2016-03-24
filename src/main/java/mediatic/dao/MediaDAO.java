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
	public List<Media>recherche(String titre, String auteur, String typeMedia, int typeTrie){
		
		List<Media>medias=new ArrayList<Media>();
		
		String desc="";
		String trie="";
		
		EntityManager em = DatabaseHelper.createEntityManager();
		
		switch(typeTrie/2){
			
			
			case 1: trie="auteur";break;
			case 2: trie="typeMedia";break;
			default: trie="titre";
		}
		if((typeTrie%2)==1){
			
			desc="desc";
			
		}
		TypedQuery<Media> q = em.createQuery("Select m From Media  m where m.titre=:%titre% and a.auteur=%:auteur% or a.typeMedia=:typeMedia order by :trie :desc ",Media.class);
	    q.setParameter("titre", titre);
	    q.setParameter("auteur", auteur);
	    q.setParameter("typeMedia", typeMedia);
	    q.setParameter("desc", desc);
	    q.setParameter("trie", trie);
	    
	    medias=q.getResultList();
	    
		return medias;
	}
	


}

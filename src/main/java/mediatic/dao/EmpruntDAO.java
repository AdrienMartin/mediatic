package mediatic.dao;

import model.Emprunt;

public class EmpruntDAO extends GenericDAO<Emprunt>{

	private static EmpruntDAO dao;
	
	private  EmpruntDAO() {
		
		 super(Emprunt.class);
	}
	public static EmpruntDAO getInstance(){
		
		if(dao==null){
			
			dao=new EmpruntDAO();
		}
		return dao;
	}

}
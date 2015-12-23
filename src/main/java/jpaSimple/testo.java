package jpaSimple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class testo {
	EntityManager em = null;
	public testo() {
		em = Persistence.createEntityManagerFactory("jpaSimple").createEntityManager();
	}

	public void SelCol(){
		List<Category> l = null;
		try{
		  l = em.createNamedQuery("Category.findAll", Category.class).getResultList();
		  for(Category c: l){
			  System.out.println(c.getId() + " " + c.getName());
		  }
		}catch(Exception e){
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testo o = new testo();
		o.SelCol();
	}

}

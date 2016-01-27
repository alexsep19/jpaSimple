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
		  
		  Category o = new Category();
		  o.setName("aaaaa");
		  em.getTransaction().begin();
//	      if (o.toString().equals("0")){
//	    	   em.persist(o);
//    	  }
//	      else 
	    	  em.merge(o);
	      em.flush();
	      em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testo o = new testo();
		o.SelCol();
	}

}

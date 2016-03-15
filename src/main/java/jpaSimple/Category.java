package jpaSimple;

import java.io.Serializable;

import javax.persistence.*;
//import org.hibernate.javax.persistence.*;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(schema = "RSS")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public Category() {
	}
//------- mine -----------
	@Transient
	public Integer getVersion() {
		return 1;
	}
	@Transient
	public String toString(){
        return id==null?"0":String.valueOf(id);
       }
//------------------------
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
	@SequenceGenerator(name = "users_seq_gen", sequenceName = "category_id_seq",allocationSize=1)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
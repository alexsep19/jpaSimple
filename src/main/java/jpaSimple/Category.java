package jpaSimple;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table (schema = "RSS")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public Category() {
	}
//------- mine -----------
	public Integer getVersion() {
		return 1;
	}

//------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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